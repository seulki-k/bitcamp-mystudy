package bitcamp.myapp2;

import java.util.List;

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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTel() {
        return tel;
    }

    // Setter 메서드들
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public void print() {
        System.out.printf("%-10s%-30s%-20s%-15s\n", name, email, password, tel);
    }
}
