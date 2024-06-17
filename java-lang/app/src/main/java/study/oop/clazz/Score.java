package study.oop.clazz;

public class Score {
  String name;
  int kor;
  int eng;
  int math;
  private int sum;
  private float aver;

  Score( String name,int kor,int eng,int math){
    this.name =  name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
    this.sum = kor + eng + math;
    this.aver = (float) sum / 3;
  }

  void printScore() {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", name, kor, eng, math, sum, aver);
  }

  void setName(String name){
    this.name = name;
  }
}
