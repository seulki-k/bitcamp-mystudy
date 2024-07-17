package study.lambda;


public class Test02 {

  interface Player{
    void play();
  }

  public static void main(String[] args) {

    //1) 일반 클래스
    class abc implements Player{

      @Override
      public void play() {
        // TODO Auto-generated method stub
        System.out.println("111");
      }
    }
    Player p1 = new abc();
    test(p1);

    //2) 익명클래스
    Player p2 = new Player() {
      @Override
      public void play() {
        System.out.println("22222");
      }
    };
    test(p2);


    //3)익명 클래스 직접 대입
    test(new Player() {
      @Override
      public void play() {
        System.out.println("3333");
      }
    });


    //4) 람다클래스
    Player p4 = ()-> {System.out.println("4444");};
    test(p4);

    //5) 람다 중괄호 생략
    Player p5 = ()-> System.out.println("555");
    test(p5);

    //6) 람다 직접 대입
    test(()->System.out.println("6666"));

  }

  static void test(Player p) {
    p.play();
  }
}
