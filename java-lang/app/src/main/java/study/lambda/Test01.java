package study.lambda;


public class Test01 {

  interface Player {
    void play();
  }


  public static void main(String[] args) {

    //1) 일반 클래스

    class abc implements Player {
      @Override
      public void play() {
        System.out.println("일반 클래스");
      }
    }

    new abc().play();

    //2)익명 클래스

    Player b = new abc() {
      @Override
      public void play() {
        System.out.println("익명클래스");
      }
    };
    b.play();
    //3) 익명 + 메서드
    new abc() {
      @Override
      public void play() {
        System.out.println("익명 2");
      }
    }.play();

    Player d =()->{
      System.out.println("람다");
    };
    d.play();

    Player e =()->System.out.println("람다2");
    e.play();

  }
}

