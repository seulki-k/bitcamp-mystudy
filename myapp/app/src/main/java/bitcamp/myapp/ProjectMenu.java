package bitcamp.myapp;

public class ProjectMenu {
    boolean choice = true;

    static void  project() {
        String line = Ansi.BOLD + "=================================" + Ansi.RESET;
        System.out.println(line);
        System.out.println(Ansi.BOLD +"[팀 프로젝트 관리 시스템]"+ Ansi.RESET);
        System.out.println("1. 회원");
        System.out.println("2. 팀");
        System.out.println("3. 프로젝트");
        System.out.println("4. 게시판");
        System.out.println("5. 도움말");
        System.out.println(Ansi.BOLD + Ansi.RED + "6. 종료" + Ansi.RESET);
        System.out.println(line);
    }
    public static boolean menu(String a){
        switch (a) {
            case "1" :
                System.out.println("회원");
                break;
            case "2":
                System.out.println("팀");
                break;
            case "3":
                System.out.println("프로젝트");
                break;
            case "4":
                System.out.println("게시판");
                break;
            case "5":
                System.out.println("도움말");
                break;
            case "6":
                System.out.println("종료합니다.");
                return false;
            case "메뉴":
                project();
                break;
            default:
                System.out.println("메뉴 번호가 올바르지 않습니다.");
                break;
        }
        return true;
    }
}
