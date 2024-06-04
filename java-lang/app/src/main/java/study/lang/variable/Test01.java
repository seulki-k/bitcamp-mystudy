package study.lang.variable;

public class Test01 {
  public static void main(String[] args) {
    // 실습
    // -primitive type의 변수를 선언하라.
    // - 각변수의 최소값, 최대값을 할당하라.
    // - 각 변수에 최소값, 최대값 범위를 벗어나는 값을 넣은 후 오류를 확인하라.
    // - ex)
    // byte b1 = -128;
    // byte b2 = 127;

    System.out.println("byte = " + Byte.BYTES + "byte");// 1byte
    System.out.println("byte 최대 값= " + Byte.MAX_VALUE);
    System.out.println("byte 최소 값 = " + Byte.MIN_VALUE);

    System.out.println("short = " + Short.BYTES + "byte");// 2byte
    System.out.println("short 최대 값= " + Short.MAX_VALUE);
    System.out.println("short 최소 값= " + Short.MIN_VALUE);

    System.out.println("int = " + Integer.BYTES + "byte");// 4byte
    System.out.println("int 최대 값= " + Integer.MAX_VALUE);
    System.out.println("int 최소 값= " + Integer.MIN_VALUE);

    System.out.println("long = " + Long.BYTES + "byte");// 8byte
    System.out.println("long 최대 값= " + Long.MAX_VALUE);
    System.out.println("long 최소 값= " + Long.MIN_VALUE);

    System.out.println("float = " + Float.BYTES + "byte"); // 4byte
    System.out.println("float 최대 값= " + Float.MAX_VALUE);
    System.out.println("float 최소 값= " + Float.MIN_VALUE);

    System.out.println("double = " + Double.BYTES + "byte"); // 8byte
    System.out.println("double 최대 값= " + Double.MAX_VALUE);
    System.out.println("double 최소 값= " + Double.MIN_VALUE);

    System.out.println("char = " + Character.BYTES + "byte"); // 2byte
    System.out.println("char 최대 값= " + (int) Character.MAX_VALUE);
    System.out.println("char 최소 값= " + (int) Character.MIN_VALUE);

    System.out.println(true); // 1
    System.out.println(false); // 0


  }
}
