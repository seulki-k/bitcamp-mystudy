package study.lang.method;


public class Test10 {
  public static void main(String[] args) {
    int[] values;
    values = create();

    System.out.println(values[1]);
  }

  static int[] create(){
    int[] arr = new int[] {100,200,300};

    return arr;
  }
}

