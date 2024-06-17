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

    // 계산 결과를 담을 변수를 준비한다.
    Calculator2 c2 = new Calculator2();
    int result =0;
    // 메서드를 호출하여 작업을 수행하고,
    // 리턴 결과는 로컬 변수에 저장한다.
    c2.plus(2);
    c2.plus(3);
    c2.minus( 1);
    c2.multiple(7);
    c2.divide(3);
    result = Calculator2.plus2(result, 2);
    System.out.printf("result = %d\n", c2.getResult());
    System.out.printf("result = %d\n", result);
    c2.clearResult();
  }

}
// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// - 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// - 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.



