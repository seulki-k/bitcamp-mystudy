package study.patterns.ex02.after2;

public class Test04 {
  public static void main(String[] args) {
    ContentPrinter printer0 = new ContentPrinter();
    //    HeaderPrinter printer1 = new HeaderPrinter(printer0,"인사말");
    FooterPrinter printer2 = new FooterPrinter(printer0,"비트캠프");

    printer2.print("안녕하세요");
  }
}
