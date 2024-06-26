package bitcamp.myapp.command;

import bitcamp.myapp.App;
import bitcamp.myapp.util.ArrayList;
import bitcamp.myapp.util.LinkedList;
import bitcamp.myapp.util.Prompt;
import bitcamp.myapp.vo.User;

public class UserCommand {

    LinkedList userList = new LinkedList();

    public void executeUserCommand(String command) {
        System.out.printf("[%s]\n", command);
        switch (command) {
            case "등록":
                addUser();
                break;
            case "조회":
                viewUser();
                break;
            case "변경":
                updateUser();
                break;
            case "삭제":
                deleteUser();
                break;
            case "목록":
                listUser();
        }
    }

    private void addUser() {
        User user = new User();
        user.setName(Prompt.input("이름?"));
        user.setEmail(Prompt.input("이메일?"));
        user.setPassword(Prompt.input("암호?"));
        user.setTel(Prompt.input("연락처?"));
        user.setNo(User.getNextSeqNo());
        userList.add(user);
        System.out.println("등록했습니다.");
    }

    private  void listUser() {
        System.out.println("번호 이름 이메일");
        for (Object obj :  userList.toArray()) {
            User user = (User) obj;
            System.out.printf("%d %s %s\n", user.getNo(), user.getName(), user.getEmail());
        }
    }

    private  void viewUser() {
        int userNo = Prompt.inputInt("회원 번호?");

        User user = (User) userList.get(userList.indexOf(new User(userNo)));
        if (user == null) {
            System.out.println("없는 회원입니다.");
            return;
        }
        System.out.printf("이름(%s)\n", user.getName());
        System.out.printf("이메일(%s)\n", user.getEmail());
        System.out.printf("연락처(%s)\n", user.getTel());
    }

    private  void updateUser() {
        int userNo = Prompt.inputInt("회원 번호?");
        User u = new User();
        u.setNo(userNo);
        User user = (User) userList.get(userList.indexOf(u));
        if (user == null) {
            System.out.println("없는 회원입니다.");
            return;
        }
        user.setName(Prompt.input("이름(%s)\n", user.getName()));
        user.setEmail(Prompt.input("이메일(%s)\n", user.getEmail()));
        user.setPassword(Prompt.input("암호"));
        user.setTel(Prompt.input("연락처(%s)\n", user.getTel()));
    }

    private void deleteUser() {
        int userNo = Prompt.inputInt("회원 번호?");
        User deletedUser = (User) userList.get(userList.indexOf(new User(userNo)));
        if (deletedUser != null) {
            userList.remove(userList.indexOf(deletedUser));
            System.out.printf("'%s' 회원을 삭제했습니다.\n", deletedUser.getName());
        } else
            System.out.println("없는 회원입니다.");
    }
    public LinkedList getUserList(){
        return userList;
    }
}
