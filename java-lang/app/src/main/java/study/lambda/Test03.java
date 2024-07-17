package study.lambda;



public class Test03 {

  interface Calculator{
    int plus(int a, int b);
  }



  static void test(Calculator c) {
    System.out.println(c.plus(100,200));
  }

  public static void main(String[] args) {

    //1) 일반 클래스
    class MyCalc implements Calculator{
      @Override
      public int plus(int a, int b) {
        return a+b;
      }
    }

    Calculator c1 = new MyCalc();
    test(c1);

    //2) 익명 클래스
    Calculator c2 = new Calculator() {
      @Override
      public int plus(int a, int b) {
        return a+b;
      }
    };

    test(c2);

    //3) 익명
    test(new Calculator() {
      @Override
      public int plus(int a, int b) {
        return a+b;
      }
    });


    //4) 람다
    Calculator c5 = (a,b)->{
      return a+b;
    };

    test(c5);
    //5)람다
    Calculator c6 = (a,b)->a+b;


    test(c6);

    //6)람다 직접대입

    test((a,b)->a+b);


  }
}

