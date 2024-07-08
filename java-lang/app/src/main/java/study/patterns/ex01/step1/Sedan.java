package study.patterns.ex01.step1;


public class Sedan extends Car {
  boolean sunroof;
  boolean auto;

  protected Sedan() {}

  public static Sedan create (String model) {
    Sedan s = new Sedan();


    switch(model) {
      case "소나타":
        s.maker = "HDCAR";
        s.model = "SONATA";
        s.cc = 1998;
        s.auto = true;
        s.sunroof = true;
        break;
      case "K7":
        s.maker = "KCAR";
        s.model = "K7";
        s.cc = 2500;
        s.auto = true;
        s.sunroof = true;
        break;
    }
    return s;

  }

  @Override
  public String toString() {
    return "Sedan [sunroof=" + sunroof + ", auto=" + auto + ", maker=" + maker + ", model=" + model
        + ", cc=" + cc + "]";
  }
}

