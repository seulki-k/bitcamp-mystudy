package study.lang.method;


public class Test09 {
  public static void main(String[] args) {
    int[] values = new int[3];
    m1(values);
    String str = "hihi";
    System.out.println(str);
    m2(str);
    System.out.println(str);

    System.out.println(values[0]);

  }

  public static void m1(int[] values) {
    values[0] = 200;
  }
  public static void m2(String str) {
    System.out.println(str);
    str = "Holy";
    System.out.println(str);
  }
}

