package study.oop.clazz;

public class Score {
  private String name;
  private int kor;
  private int eng;
  private int math;
  private int sum;
  private float aver;

  Score( String name,int kor,int eng,int math){
    this.setName(name);
    this.setKor(kor);
    this.setEng(eng);
    this.setMath(math);
    this.setSum(kor + eng + math);
    this.setAver((float) getSum() / 3);
  }

  void printScore() {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", getName(), getKor(), getEng(), getMath(), getSum(), getAver());
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    this.kor = kor;
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    this.eng = eng;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public int getSum() {
    return sum;
  }

  public void setSum(int sum) {
    this.sum = sum;
  }

  public float getAver() {
    return aver;
  }

  public void setAver(float aver) {
    this.aver = aver;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
