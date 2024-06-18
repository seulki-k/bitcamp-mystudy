package study.oop.clazz;

//연습 : 클래스 문법을 메서드 분류하는 용도로 사용

public class Test01 {

  //1)메서드 분류
  //2)static 필드 사용
  //3)non-static 필드 사용
  //4)인스턴스 메서드 사용
  //5)Private, getter 사용
  //  6) 인스턴스 메서드 사용 " clear();

  public static void main(String[] args) {
    // 다음 식을 연산자 우선 순위를 고려하지 않고 순서대로 계산하라!
    // 2 + 3 - 1 * 7 / 3 = ?

    Calculator c1 = new Calculator();
    c1.plus(2);
    c1.plus( 3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);

    System.out.printf("result = %d\n", c1.getRsult());

    c1.clear();

    System.out.printf("result = %d\n", c1.getRsult());

  }
}
// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.



