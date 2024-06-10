package bitcamp.myapp2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectMenu {
    static void  project() {

        String[] menus = new String[]{ //menu 목록들 저장.
                "회원",
                "팀",
                "프로젝트",
                "게시판",
                "도움말",
                "종료"};

        String line = Ansi.BOLD + "=================================" + Ansi.RESET;

        System.out.println(line);

        for (int i =0;i<menus.length;i++) { //메뉴 목록들 출력.
            if(menus[i].equals("종료")){
                System.out.println(Ansi.BOLD + Ansi.RED + (i+1) + ". " + menus[i] + Ansi.RESET);
            }else {
                System.out.println((i+1)+". " + menus[i]);
            }
        }

        System.out.println(line);

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print(">");
            try {
                int menuNo =scanner.nextInt();
                if (menuNo >= 1 && menuNo <= menus.length) {
                    if (menus[menuNo - 1].equals("종료")) {
                        System.out.println(menus[menuNo - 1]);
                        break;
                    } else {
                        System.out.println(menuNo + ". " + menus[menuNo - 1]);
                    }
                } else {
                    System.out.println("메뉴번호가 올바르지 않습니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
