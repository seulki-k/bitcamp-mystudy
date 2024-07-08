package study.patterns.ex01.step6;

public class SonataFactory implements CarFactory {

  @Override
  public Car createCar() {
    Sedan s1 = new Sedan();

    s1.maker = "HDCAR";
    s1.model = "SONATA";
    s1.cc = 1998;
    s1.auto = true;
    s1.sunroof = true;
    return s1;
  }

}
