package bitcamp.myapp2;
import java.util.Scanner;

public class ProjectMenu {
    static Scanner scanner = new Scanner(System.in);
    static String[] menus = new String[]{ //menu 목록들 저장.
            "회원",
            "팀",
            "프로젝트",
            "게시판",
            "도움말",
            "종료"};

    static boolean isValidateMenu(int menuNo){ //입력 가능한 값인지 출력
        return menuNo >= 1 && menuNo <= menus.length;
    }
    static String getMenuTitle(int menuNo){ //메뉴 이름 출력
        return isValidateMenu(menuNo) ? menus[menuNo-1] : null;
    }

    static void printMenu(String[] menus) { //메뉴판 출력
        String line = Ansi.BOLD + "=================================" + Ansi.RESET;
        System.out.println(line);

        for (int i = 0; i < menus.length; i++) { // 메뉴 목록들 출력
            if (menus[i].equals("종료")) {
                System.out.println(Ansi.BOLD + Ansi.RED + (i + 1) + ". " + menus[i] + Ansi.RESET);
            } else {
                System.out.println((i + 1) + ". " + menus[i]);
            }
        }
        System.out.println(line);
    }

    static void  project() {
        printMenu(menus);
        while(true) {
            System.out.print(">");
            String menuNo2 = scanner.next();
            if(menuNo2.equals("menu")){
               printMenu(menus);
            }
            else{
               try {
                    int menuNo = Integer.parseInt(menuNo2);
                   String menutitle = getMenuTitle(menuNo); //설명하는 변수
                   if(menutitle == null){
                       System.out.println("유요한 번호가 아닙니다.");
                   }else if(menutitle.equals(("종료"))){
                       break;
                   }else {
                       System.out.println(menuNo + ". " + menutitle);
                   }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                }
            }
        }
        scanner.close();
    }
}
