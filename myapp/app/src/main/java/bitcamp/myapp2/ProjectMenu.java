package bitcamp.myapp2;

import java.util.Scanner;

public class ProjectMenu {
    static Scanner scanner = new Scanner(System.in);
    static String state = "메인"; // 현재 사용자 위치를 나타내는 state 변수. 초기 "메인"
    static String[][] menus = { // 2차원 배열로 메뉴 목록 저장
            {"회원", "팀", "프로젝트", "게시판", "도움말", "종료"}, // 메인 메뉴 0
            {"등록", "목록", "조회", "변경", "삭제", "이전"}, // 회원 메뉴 1
            {"등록", "목록", "조회", "변경", "삭제", "이전"}, // 팀 메뉴 2
            {"등록", "목록", "조회", "변경", "삭제", "이전"}, // 프로젝트 메뉴 3
            {"등록", "목록", "조회", "변경", "삭제", "이전"}, // 게시판 메뉴 4
            {"등록", "목록", "조회", "변경", "삭제", "이전"}  // 도움말 메뉴 5
    };

    static String getMenuTitle(int menuNo) { // 메뉴 이름 출력
        int currentIndex = getCurrentMenuIndex();
        if (menuNo == 9) {
            if (!state.equals("메인")) {
                return menus[currentIndex][menus[currentIndex].length - 1]; // "이전" 메뉴 처리
            } else {
                return null;
            }
        } else if (state.equals("메인") && menuNo <= menus[currentIndex].length) {
            return menus[currentIndex][menuNo - 1];
        } else if (!state.equals("메인") && menuNo <= menus[currentIndex].length - 1) {
            return menus[currentIndex][menuNo - 1];
        } else {
            return null;
        }
    }

    //변수에서 2차원 배열로 메뉴룰 변경하여 상태 타입을 숫자로 표현 - CurrentIndex
    static int getCurrentMenuIndex() {
        switch (state) {
            case "메인": return 0;
            case "회원": return 1;
            case "팀": return 2;
            case "프로젝트": return 3;
            case "게시판": return 4;
            case "도움말": return 5;
            default: return 0;
        }
    }

    static void printMenu() { // 메뉴판 출력
        int currentIndex = getCurrentMenuIndex();
        String line = Ansi.BOLD + "=================================" + Ansi.RESET;
        System.out.println(line);
        System.out.println(Ansi.BOLD + "[" + state + "]" + Ansi.RESET);
        for (int i = 0; i < menus[currentIndex].length; i++) { // 메뉴 목록 출력
            if (menus[currentIndex][i].equals("종료")) {
                System.out.println(Ansi.BOLD + Ansi.RED + (i + 1) + ". " + menus[currentIndex][i] + Ansi.RESET);
            } else if (menus[currentIndex][i].equals("이전")) {
                System.out.println(Ansi.BOLD + Ansi.RED + "9. " + menus[currentIndex][i] + Ansi.RESET);
            } else {
                System.out.println((i + 1) + ". " + menus[currentIndex][i]);
            }
        }
        System.out.println(line);
    }

    static String prompt() { // 메뉴 입력받는 창
        System.out.print(Ansi.BOLD + "메인" + (state.equals("메인") ? "" : "/" + state) + Ansi.RESET + ">");
        return scanner.nextLine();
    }

    static void project() { // 메인 메뉴
        printMenu();
        while (true) {
            String command = prompt(); // 값 입력
            if (command.equals("menu")) { // 입력받은 값이 menu면 메뉴 화면 다시 출력
                printMenu();
            } else {
                try { // 입력 받은 값이 문자열일 경우 예외처리 및 int형으로 형변환
                    int menuNo = Integer.parseInt(command);
                    String menutitle = getMenuTitle(menuNo); // 입력받은 값에 해당하는 메뉴 출력, 해당하지 않으면 null 출력
                    if (menutitle == null) {
                        System.out.println("유효한 번호가 아닙니다.");
                    } else if (menutitle.equals("종료")) { // 입력 받은 값에 해당하는 것이 종료이면 종료.
                        System.out.println("종료");
                        break;
                    } else {
                        System.out.println(menuNo + ". " + menutitle); // 메뉴 출력
                        subProject(menuNo); //서브 프로젝트 시작
                    }
                } catch (NumberFormatException e) { // menu를 제외한 문자형 예외처리 (String -> int 형변환 시 에러)
                    System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                }
            }
        }
        scanner.close();
    }

    static void subProject(int menuNo) {
        switch (menuNo) {
            case 1: state = "회원";break;
            case 2: state = "팀";break;
            case 3: state = "프로젝트";break;
            case 4: state = "게시판";break;
            case 5: state = "도움말";break;
        }

        printMenu(); //서브 프로젝트 메뉴 출력.

        while (true) {
            String command = prompt();
            if (command.equals("menu")) { // 입력받은 값이 menu면 메뉴 화면 다시 출력
                printMenu();
            } else { // 서브 메뉴 입력창
                try {
                    int menuNo2 = Integer.parseInt(command);
                    String menutitle = getMenuTitle(menuNo2); // 입력받은 값에 해당하는 메뉴 출력, 해당하지 않으면 null 출력
                    if (menutitle == null) {
                        System.out.println("유효한 번호가 아닙니다.");
                    } else if (menutitle.equals("이전")) { // 입력 받은 값이 이전에 해당하면 메인으로 이동
                        state = "메인";
                        System.out.println(Ansi.BOLD + "이전" + Ansi.RESET);
                        break;
                    } else { // 선택한 메뉴 출력
                        System.out.println(menuNo2 + ". " + menutitle);
                    }
                } catch (NumberFormatException e) { // menu를 제외한 문자형 예외처리 (String -> int 형변환 시 에러)
                    System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
                }
            }
        }
    }
}