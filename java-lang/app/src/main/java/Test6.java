// 실습
// - 애플리케이션 아규먼트를 다음과 같이 결과가 나오도록 모두 출력
//  $java -cp... Test6 aaa bbb ccc ddd
//  'aaa'
//  'bbb'
//  'ccc'
//  'ddd'
// 

class Test6 {
    public static void main(String[] a) {
        for (String x : a) { // int i =0;i < a.length; i++ // String[] x = a[i]
            System.out.println(x);
        }
    }
}
