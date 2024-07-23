package study.patterns.ex02.after2;



public class SignPrinter extends PrinterDecorator{

  String sign;

  public SignPrinter(Printer printer, String sign) {
    super(printer);
    this.sign = sign;
  }

  @Override
  public void print(String content) {
    origin.print(content);

    System.out.println();
    System.out.printf("form %s\n",sign);
    System.out.println();
  }

}
