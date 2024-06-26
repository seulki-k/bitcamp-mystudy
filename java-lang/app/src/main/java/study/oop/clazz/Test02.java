package study.oop.clazz;

import java.util.ArrayList;

public class Test02 {
  public static void main(String[] args) {
    ArrayList<Score> s1 = new ArrayList<>();

    s1.add(new Score("홍길동",100,95,80));
    s1.add(new Score("임꺽정", 90,80, 75));
    s1.add(new Score("유관순", 80, 70,65));

    s1.set(1, new Score("강슬기",100,90,80)); // 값 변경

    for(Score s : s1) { //이름 변경
      if(s.getName().equals("홍길동")) {
        s.setName("김미미");
      }
    }

    for(Score s : s1) {
      s.printScore();
    }
  }
}