package study.lambda;


public class Test05 {
  static class MyCalculator{
    public static int plus(int a, int b) {return a + b;};
    public static int minus(int a, int b) {return a - b;};
    public static int multiple(int a, int b) {return a*b;};
    public static int divide(int a, int b) {return a/b;};

  }

  interface Calculator{
    int compute(int x, int y);
  }

  public static void main(String[] args) {

    //1) 일반 클래스
    class My implements Calculator{
      @Override
      public int compute(int x,int y) {
        return MyCalculator.plus(x,y);
      }
    }

    My c1 = new My();
    int result = c1.compute(100, 200);
    System.out.println(c1);



    //2)익명 클래스
    //Calculator c2 = MyCalculator::plus;
    Calculator c2 = new Calculator(){
      @Override
      public int compute(int x,int y) {
        return MyCalculator.plus(x,y);
      }
    };

    System.out.println(c2.compute(100, 200));

    //2)익명 클래스-2
    System.out.println(new Calculator(){
      @Override
      public int compute(int x,int y) {
        return MyCalculator.plus(x,y);
      }
    }.compute(100, 200));


    //3) lambda
    Calculator c3 = (x, y) -> {return MyCalculator.plus(x,y);};

    System.out.println(c3.compute(100, 200));

    //4) lambda - 중괄호 생략
    Calculator c4 = (x, y) -> MyCalculator.plus(x,y);

    System.out.println(c4.compute(100, 200));


  }
}
