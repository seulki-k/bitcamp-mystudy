package study.lang.method;


public class Test08 {
  static int value;
  public static void main(String[] args) {
    value = 100;
    m1();
    System.out.println(value);

  }

  public static void m1() {
    value = 200;
  }
}

