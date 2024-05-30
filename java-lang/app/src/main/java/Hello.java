public class Hello {
    public static void main(String[] args) {

        String abc = "hello world";

        char[] x = new char[abc.length()];

        for (int i = 0; i < abc.length(); i++) {
            x[i] = Character.toUpperCase(abc.charAt(i));
        }
        String y = new String(x);
        System.out.println(y.replaceAll(" ", ""));
    }
}
