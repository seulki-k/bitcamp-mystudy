package bitcamp.myapp2;

public class User {
    private String name;
    private String email;
    private String password;
    private String tel;

    public User(String name, String email, String password, String tel) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }

    public void print() {
        System.out.printf("%-10s%-30s%-20s%-15s\n", "이름" ,"이메일", "비밀번호", "전화번호" );
        System.out.printf("%-10s%-30s%-20s%-15s\n", name, email, password, tel);
    }
}
