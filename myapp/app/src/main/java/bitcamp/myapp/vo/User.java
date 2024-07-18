package bitcamp.myapp.vo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

// 메모리 설계도
public class User {

    private static int seqNo;

    private int no;
    private String name;
    private String email;
    private String password;
    private String tel;

    public User() {
    }

    public User(int no) {
        this.no = no;
    }

    public static int getNextSeqNo() {
        return ++seqNo;
    }

    public byte[] getBytes() throws IOException {

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            // 4 Byte 단위로 분할하여 바이트를 출력 스트림으로 사용\
            // 2byte - user 데이터 개 수, 2byte - user 데이터 바이트 배열 크기
            // 4byte - no Field
            // 2byte - name byte 배열 크기, * byte - name 바이트
            // 2byte - email, * byte
            // 2byte - password, * byte
            out.write(no >> 24);
            out.write(no >> 16);
            out.write(no >> 8);
            out.write(no);

            byte[] bytes = name.getBytes(StandardCharsets.UTF_8);
            out.write(bytes.length >> 8);
            out.write(bytes.length);
            out.write(bytes);

            bytes = email.getBytes(StandardCharsets.UTF_8);
            out.write(bytes.length >> 8);
            out.write(bytes.length);
            out.write(bytes);

            bytes = password.getBytes(StandardCharsets.UTF_8);
            out.write(bytes.length >> 8);
            out.write(bytes.length);
            out.write(bytes);

            bytes = tel.getBytes(StandardCharsets.UTF_8);
            out.write(bytes.length >> 8);
            out.write(bytes.length);
            out.write(bytes);

            return out.toByteArray(); // return 하기 전에 out.close()가 자동 호출된다.
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return no == user.no;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(no);
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
