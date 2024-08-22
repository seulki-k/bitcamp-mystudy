package bitcamp.myapp.dao;

import org.apache.ibatis.session.SqlSession;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;

public class DaoFactory {
    // MyBatis의 SqlSession을 주입받아 데이터베이스 작업을 수행합니다.
    private org.apache.ibatis.session.SqlSession sqlSession;

    // DaoFactory의 생성자로, SqlSession 객체를 초기화합니다.
    public DaoFactory(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // 주어진 DAO 인터페이스 타입의 프록시 객체를 생성합니다.
    public <T> T createObject(Class<T> daoType) throws Exception {
        return (T) Proxy.newProxyInstance(
                this.getClass().getClassLoader(), // 현재 클래스의 클래스 로더
                new Class[]{daoType}, // 생성할 프록시 객체가 구현할 인터페이스
                this::invoke // 프록시 객체의 메서드 호출 시 호출될 메서드 참조
        );
    }

    // 프록시 객체의 메서드가 호출될 때 실행되는 메서드입니다.
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        // 인터페이스의 이름을 네임스페이스로 사용합니다.
        String namespace = proxy.getClass().getInterfaces()[0].getSimpleName();
        // 호출된 메서드의 이름을 SQL ID로 사용합니다.
        String sqlId = method.getName();
        // 네임스페이스와 SQL ID를 결합하여 MyBatis의 SQL 문장을 만듭니다.
        String statement = String.format("%s.%s", namespace, sqlId);

        // 메서드에 전달된 인수를 처리하여 MyBatis에 전달할 파라미터를 설정합니다.
        Object paramValue = null;
        if (args != null) {
            if (args.length == 1) {
                // 인수가 하나일 경우 그대로 사용합니다.
                paramValue = args[0];
            } else {
                // 인수가 여러 개일 경우, @Param 어노테이션을 통해 매핑합니다.
                Parameter[] params = method.getParameters();
                HashMap<String, Object> map = new HashMap<>();
                for (int i = 0; i < args.length; i++) {
                    // 각 파라미터의 @Param 어노테이션 값을 키로 사용하여 인수를 맵에 저장합니다.
                    Param anno = params[i].getAnnotation(Param.class);
                    map.put(anno.value(), args[i]);
                }
                paramValue = map;
            }
        }

        // 메서드의 반환 타입에 따라 MyBatis의 적절한 메서드를 호출합니다.
        Class<?> returnType = method.getReturnType();

        if (returnType == List.class) {
            // 반환 타입이 List일 경우, selectList 메서드를 호출하여 결과를 반환합니다.
            return sqlSession.selectList(statement, paramValue);
        } else if (returnType == int.class || returnType == void.class || returnType == boolean.class) {
            // 반환 타입이 int, void, boolean일 경우, insert 메서드를 호출하여 결과를 반환합니다.
            int count = sqlSession.insert(statement, paramValue);
            if (returnType == boolean.class) {
                // 반환 타입이 boolean일 경우, 삽입된 행의 수가 0보다 큰지 확인하여 true/false 반환합니다.
                return count > 0;
            } else if (returnType == void.class) {
                // 반환 타입이 void일 경우, null을 반환합니다.
                return null;
            } else {
                // 반환 타입이 int일 경우, 삽입된 행의 수를 반환합니다.
                return count;
            }
        } else {
            // 기타 반환 타입일 경우, selectOne 메서드를 호출하여 단일 결과를 반환합니다.
            return sqlSession.selectOne(statement, paramValue);
        }
    }
}
