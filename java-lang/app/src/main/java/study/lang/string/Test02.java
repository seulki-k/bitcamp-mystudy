package study.lang.string;

public class Test02 {
  public static void main(String[] args) {
    String s = new String("aaa");

    String s2 = new String("aaa");

    System.out.println(s==s2);
    System.out.println(s.equals(s2));
  }
}
