package study.patterns.ex02.after1;



public class Printer5 {

  Printer origin = new Printer();
  String sign;

  public Printer5(String sign) {
    this.sign = sign;
  }

  void print(String content) {
    origin.print(content);
    System.out.println();
    System.out.printf("form %s\n",sign);
    System.out.println();
  }

}
