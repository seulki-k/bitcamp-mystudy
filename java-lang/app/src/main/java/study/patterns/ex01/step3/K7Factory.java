package study.patterns.ex01.step3;

public class K7Factory implements CarFactory {

  @Override
  public Car createCar() {
    Sedan s = new Sedan();
    s.maker = "KCAR";
    s.model = "K7";
    s.cc = 2500;
    s.auto = true;
    s.sunroof = true;
    return s;
  }
}
