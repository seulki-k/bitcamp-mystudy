package study.patterns.ex02.after2;

public class Test06 {
  public static void main(String[] args) {
    ContentPrinter printer0 = new ContentPrinter();
    SignPrinter printer1 = new SignPrinter(printer0,"홍길동");
    HeaderPrinter printer2 = new HeaderPrinter(printer1,"인사말");
    FooterPrinter printer3 = new FooterPrinter(printer2,"비트캠프");

    printer3.print("안녕하세요");
  }
}