package study.lang.string;

public class Test01 {
  public static void main(String[] args) {
    String s = new String("aaa");

    String s2 = new String("aaa");

    System.out.println(s==s2); //false
    System.out.println(s.equals(s2)); //true

    String s3 = "aaa";
    String s4 = "aaa";

    System.out.println(s3==s4); //true
    System.out.println(s3.equals(s4)); //true
  }
}
