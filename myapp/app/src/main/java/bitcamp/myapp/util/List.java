package bitcamp.myapp.util;

// 데이터 목록을 다루는 일을 할 객체 사용법
// => 객체에게 일을 시킬 때 다음의 메서드를 호출하여 일을 시켜라
public interface List {
    //데이터를 더할 때 호출할 메서드
    // 인터페이스는 접근제어자 미입력 시 default가 아닌 public
    //abstract(추상 메서드) 생략 가능
    //규칙이기 때문에 메서드의 시그너처만 정의
     void add(Object value);

    Object remove(int index);

    Object get(int index);

    int indexOf(Object value);

    Object[] toArray();

    public static final int hour = 24;

    int size();

}
