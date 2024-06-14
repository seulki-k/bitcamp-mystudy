package bitcamp.myapp2;

import java.util.List;
import java.util.Scanner;

public class UserCommand {
    static Scanner scanner = new Scanner(System.in);

    public static void userMenu(List<User> users, String menutitle) {
        if (menutitle.equals("등록")) {
            userAdd(users);
        } else if (menutitle.equals("목록")) {
            printUsers(users);
        } else if (menutitle.equals("조회")) {
            System.out.print("조회할 회원 이름: ");
            String names = scanner.nextLine();
            User check = userCheck(users, names);
            if (check != null) {
                System.out.printf("%-10s%-30s%-20s%-15s\n", "이름", "이메일", "비밀번호", "전화번호");
                check.print();
            } else {
                System.out.println("조회할 대상이 없습니다.");
            }
        } else if (menutitle.equals("변경")) {
            userUpdate(users);
        } else if (menutitle.equals("삭제")) {
            userRemove(users);
        }
    }

    public static void userUpdate(List<User> users) {
        System.out.print("변경할 회원 이름: ");
        String names = scanner.nextLine();
        User checkMember = userCheck(users, names); //입력한 값과 매칭된 Arraylist주소 값 저장.
        if (checkMember != null) {
            System.out.println("현재 회원 이름: " + checkMember.getName());
            System.out.print("새로운 이름을 입력하세요: ");
            String newName = scanner.nextLine();
            checkMember.setName(newName); // user1, checkMember 동일한 객체 참조 중..
            System.out.println("현재 회원 이메일: " + checkMember.getEmail());
            System.out.print("새로운 이메일을 입력하세요: ");
            String newEmail = scanner.nextLine();
            checkMember.setEmail(newEmail);
            System.out.println("현재 회원 비밀번호: " + checkMember.getPassword());
            System.out.print("새로운 비밀번호를 입력하세요: ");
            String newPassword = scanner.nextLine();
            checkMember.setPassword(newPassword);
            System.out.println("현재 회원 전화번호: " + checkMember.getTel());
            System.out.print("새로운 전화번호 입력하세요: ");
            String newTel = scanner.nextLine();
            checkMember.setTel(newTel);
        } else {
            System.out.println("해당 이름의 회원이 없습니다.");
        }
    }

    public static void userAdd(List<User> users) {
        System.out.println("이름?");
        String name = scanner.nextLine();
        System.out.println("이메일?");
        String email = scanner.nextLine();
        System.out.println("암호?");
        String password = scanner.nextLine();
        System.out.println("연락처?");
        String tel = scanner.nextLine();
        User user1 = new User(name, email, password, tel); //Static User user1; 클래스 미리 선언함.
        users.add(user1); // List<User> users = new ArrayList<>(); Main에서 미리 선언함.
    }

    public static void userRemove(List<User> users) {
        System.out.print("삭제할 회원 이름 : ");
        int initsize = users.size();
        String names = scanner.nextLine();
        users.removeIf(user -> user.getName().equals(names)); //파라미터는 List<User>를 user로 표현
        if (initsize != users.size()) {
            System.out.println("삭제가 성공적으로 완료되었습니다.");
        } else {
            System.out.println("삭제할 대상이 없습니다.");
        }

    }

    public static User userCheck(List<User> users, String names) {
        for (User user : users) {
            if (user.getName().equals(names)) {
                return user;
            }
        }
        return null;
    }


    public static void printUsers(List<User> users) {
        System.out.printf("%-10s%-30s%-20s%-15s\n", "이름", "이메일", "비밀번호", "전화번호");
        for (User user : users) {
            user.print();
        }
    }
}
