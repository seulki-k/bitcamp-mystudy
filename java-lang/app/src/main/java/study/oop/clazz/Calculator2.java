package study.oop.clazz;

public class Calculator2 {
  private int result = 0;

  int plus(int b) {
    return result +=b;
  }
  static int plus2(int a,int b) {
    return a + b;
  }
  int minus(int b) {
    return result -=b;
  }

  int multiple(int b) {
    return result *=b;
  }

  int divide(int b) {
    return result /= b;
  }

  int getResult() {
    return this.result;
  }
  void clearResult() {
    this.result=0;
  }
}
