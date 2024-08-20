package study.patterns.ex02.after1;

public class Printer6  {

  Printer2 origin;
  String sign;

  public Printer6(String sign, String header) {
    origin = new Printer2(header);
    this.sign = sign;
  }


  void print(String content) {
    origin.print(content); //헤더 + 내용

    System.out.println();
    System.out.printf("form %s\n",sign);
    System.out.println();


  }

}