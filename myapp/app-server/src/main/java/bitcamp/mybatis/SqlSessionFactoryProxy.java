package bitcamp.mybatis;

import org.apache.ibatis.session.*;

import java.sql.Connection;

public class SqlSessionFactoryProxy implements SqlSessionFactory {
    private SqlSessionFactory original;

    // SqlSession 객체를 담을 스레드 전용 변수
    ThreadLocal<SqlSession> sqlSessionThreadLocal = new ThreadLocal<>();

    public SqlSessionFactoryProxy(SqlSessionFactory original) {
        this.original = original;
    }


    @Override
    public SqlSession openSession() {
        return original.openSession();
    }

    @Override
    public SqlSession openSession(boolean autoCommit) {

        // 1) 스레드 저장소 보관된 SqlSession 객체를 찾는다.
        SqlSession sqlSession = sqlSessionThreadLocal.get();

        // 2) 없으면,
        if(sqlSession == null) {
            //  - 오리지널 객체를 통해 새로 얻는다.
            sqlSession = original.openSession(autoCommit);
            //  - 스레드 보관소에 저장한다.
            sqlSessionThreadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    @Override
    public SqlSession openSession(Connection connection) {
        return null;
    }

    @Override
    public SqlSession openSession(TransactionIsolationLevel level) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, Connection connection) {
        return null;
    }

    @Override
    public Configuration getConfiguration() {
        return null;
    }
}
