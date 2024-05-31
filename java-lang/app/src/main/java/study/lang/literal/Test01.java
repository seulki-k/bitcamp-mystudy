package study.lang.literal;

// 실습
// - 리터럴을 사용하여 다음과 같이 출력되게하라
// -출력
//  100
//  3.14
//  가
//  가나다
//  true
// - 결과

public class Test01 {
    public static void main(String[] args) {
        // 코드를 완성하라
        int a = 100;
        System.out.println(a); // 정수 리터럴 : 100
        float b = 3.14f;
        System.out.println(b); // 부동 소수점 리터럴 : 3.14
        char c = '가';
        System.out.println(c); // 문자 '가
        String d = "가나다";
        System.out.println(d); // 문자열 "가나다"
        boolean f = true;
        System.out.println(f); // 논리 true
    }
}
