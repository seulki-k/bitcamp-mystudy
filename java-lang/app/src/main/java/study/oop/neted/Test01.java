package study.oop.neted;

public class Test01 {

  interface Printer{
    void print();
  }

  public static void main(String[] args) {

    Printer obj;
    obj = () -> {
      // TODO Auto-generated method stub
      System.out.println("Hello!");};
      obj.print();
  }
}
