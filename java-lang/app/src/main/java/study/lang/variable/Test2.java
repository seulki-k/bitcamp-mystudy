package study.lang.variable;

// 실습
// 문자 코드를 저장하는 방법을 확인하라
//

public class Test2 {
  public static void main(String[] args) {
    char c1 = 44032; // 변수에 '가' 문자의 코드를 정수 값으로 저장하라.

    char c2 = 0xac00;
    char c3 = '\uAC00'; // 변수에 '가' 문자의 코드를 /uxxxxx 형태의 유니코드로 표현법으로 저장

    char c4 = '가'; // 변수에 '가' 문자의 코드를 가장 편리한 방법으로 저장하라.

    System.out.println(c1);

    System.out.println(c2);
    System.out.println(c3);

    System.out.println(c4);
  }
}
