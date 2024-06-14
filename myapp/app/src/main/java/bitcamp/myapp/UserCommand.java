package bitcamp.myapp;

public class UserCommand {
    static final int MAX_SIZE = 100;
    static int userLength = 0;
    static User[] users = new User[MAX_SIZE];

    static void executeUserCommand(String command) {
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

    static void addUser() {
        User user = new User();
        user.name = Prompt.input("이름?");
        user.email = Prompt.input("이메일?");
        user.password = Prompt.input("암호?");
        user.tel = Prompt.input("연락처?");
        users[userLength++] = user;
    }

    static void listUser() {
        System.out.println("번호 이름 이메일");
        for (int i = 0; i < userLength; i++) {
            User user = users[i];
            System.out.printf("%d %s %s\n", (i + 1), user.name, user.email);
        }
    }

    static void viewUser() {
        int userNo = Integer.parseInt(Prompt.input("회원 번호?"));
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return;
        }
        User user = users[userNo - 1];
        System.out.printf("이름(%s)\n", user.name);
        System.out.printf("이메일(%s)\n", user.email);
        System.out.printf("연락처(%s)\n", user.tel);
    }

    static void updateUser() {
        int userNo = Integer.parseInt(Prompt.input("회원 번호?"));
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return;
        }
        User user = users[userNo - 1];
        user.name = Prompt.input(String.format("이름(%s)\n", user.name));
        user.email = Prompt.input(String.format("이메일(%s)\n", user.email));
        user.password = Prompt.input("암호");
        user.tel = Prompt.input(String.format("연락처(%s)\n", user.tel));
    }

    static void deleteUser() {
        int userNo = Integer.parseInt(Prompt.input("회원 번호?"));
        if (userNo < 1 || userNo > userLength) {
            System.out.println("없는 회원입니다.");
            return;
        }

        //다음 값을 앞으로 당긴다.
        for (int i = userNo; i < userLength; i++) {
            users[i - 1] = users[i];
            users[i - 1] = users[i];
            users[i - 1] = users[i];
            users[i - 1] = users[i];
        }
        userLength--;
        users[userLength] = null;
        System.out.println("삭제했습니다.");
    }
}
