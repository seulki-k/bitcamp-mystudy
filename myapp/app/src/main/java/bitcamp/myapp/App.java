package bitcamp.myapp;

import bitcamp.menu.MenuGroup;
import bitcamp.menu.MenuItem;
import bitcamp.myapp.command.HelpCommand;
import bitcamp.myapp.command.HistoryCommand;
import bitcamp.myapp.command.board.*;
import bitcamp.myapp.command.project.*;
import bitcamp.myapp.command.user.*;
import bitcamp.util.Prompt;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Project;
import bitcamp.myapp.vo.User;

import java.io.*;
import java.util.*;

public class App {

    MenuGroup mainMenu = new MenuGroup("메인");
    List<User> userList = new ArrayList();
    List<Project> projectList = new LinkedList();
    List<Board> boardList = new LinkedList();

    public App() {

        MenuGroup userMenu = new MenuGroup("회원");
        userMenu.add(new MenuItem("등록", new UserAddCommand(userList)));
        userMenu.add(new MenuItem("목록", new UserListCommand(userList)));
        userMenu.add(new MenuItem("조회", new UserViewCommand(userList)));
        userMenu.add(new MenuItem("변경", new UserupdateCommand(userList)));
        userMenu.add(new MenuItem("삭제", new UserDeleteCommand(userList)));
        mainMenu.add(userMenu);

        MenuGroup projectMenu = new MenuGroup("프로젝트");
        ProjectMemberHandler memberHandler = new ProjectMemberHandler(userList);
        projectMenu.add(new MenuItem("등록", new ProjectAddCommand(projectList, memberHandler)));
        projectMenu.add(new MenuItem("목록", new ProjectListCommand(projectList)));
        projectMenu.add(new MenuItem("조회", new ProjectViewCommand(projectList)));
        projectMenu.add(new MenuItem("변경", new ProjectUpdateCommand(projectList, memberHandler)));
        projectMenu.add(new MenuItem("삭제", new ProjectDeleteCommand(projectList)));
        mainMenu.add(projectMenu);

        MenuGroup boardMenu = new MenuGroup("게시판");
        boardMenu.add(new MenuItem("등록", new BoardAddCommand(boardList)));
        boardMenu.add(new MenuItem("목록", new BoardListCommand(boardList)));
        boardMenu.add(new MenuItem("조회", new BoardViewCommand(boardList)));
        boardMenu.add(new MenuItem("변경", new BoardUpdateCommand(boardList)));
        boardMenu.add(new MenuItem("삭제", new BoardDeleteCommand(boardList)));
        mainMenu.add(boardMenu);

        mainMenu.add(new MenuItem("도움말", new HelpCommand()));
        mainMenu.add(new MenuItem("명령내역", new HistoryCommand()));

        mainMenu.setExitMenuTitle("종료");
    }

    public static void main(String[] args) {
        new App().execute();
    }

    void execute() {
        System.out.println("      [프로젝트 관리 시스템]");
        System.out.println("----------------------------------");
        try {
            loadData();
            mainMenu.execute();
        } catch (Exception ex) {
            System.out.println("실행 오류!");
        } finally {
            saveData();
        }
        System.out.println("종료합니다.");
        Prompt.close();
    }

    private void loadData() {
        loadUsers();
        loadProjects();
        loadBoards();

        System.out.println("데이터를 로딩 했습니다.");
    }

    private void loadUsers() {
        try (FileInputStream in = new FileInputStream("user.data")) {
            //입력 스트림에서 한 바이트(8비트)를 읽고 첫 번째 바이트를 왼쪽으로 8비트(1바이트) 이동
            //첫 번째 바이트를 8비트 왼쪽으로 이동시킨 값과 두 번째 바이트를 비트 OR 연산
            //예를 들어, 첫 번째 바이트가 0x12이고 두 번째 바이트가 0x34라면, (0x12 << 8) | 0x34는 0x1200 | 0x0034이 되어 0x1234가 된다.
            // 16진수 -> 2진수 0x12(16진수) = 0001 0010(2진수) << 8 => 0001 0010 0000 0000(2진수) => 0x1200(16진수)
            int userLength = (in.read() << 8) | in.read();

            for (int i = 0; i < userLength; i++) {
                //한 개의 User 데이터 바이트 배열 크기 : 파일에서 2바이트를 읽는다.
                int len = (in.read() << 8) | in.read();
                //한 개의 user 데이터 바이트 배열 : 위에서 지정한 개 수 만큼 바이트 배열을 읽는다.
                byte[] bytes = new byte[len];
                in.read(bytes);

                //User 바이트 배열을 가지고 User 객체를 생성
                User user = User.valueOf(bytes);
                userList.add(user);

            }
        } catch (IOException e) {
            System.out.println("회원 정보 로딩 중 오류 발생");
        }

    }

    private void loadProjects() {
    }

    private void loadBoards() {
    }


    private void saveData() {
        saveUsers();
        saveProjects();
        saveBoards();
        System.out.println("데이터를 저장 했습니다.");
    }

    private void saveUsers() {
        //try 객체를 나갈 때 자동 close 해준다.
        try (FileOutputStream out = new FileOutputStream("user.data");) {
            // 몇 개의 데이터를 읽을지 알려주기 위해 저장 데이터의 개수를 출력한다.
            out.write(userList.size() >> 8);
            out.write(userList.size());

            for (User user : userList) {
                //user 객체에 저장된 값을 꺼내 파일로 출력한다.
                byte[] bytes = user.getBytes();
                //User 데이터의 바이트 배열 크기를 출력한다.
                // 왜? 읽을 때 한 갱 분량의 User 바이트 배열을 읽기 위해
                out.write(bytes.length >> 8);
                out.write(bytes.length);
                out.write(bytes);

                out.write(user.getBytes());
                //바이트 배열을 파일로 출력
            }
        } catch (IOException e) {
            System.out.println("회원 정보 저장 중 오류 발생!");
        }
    }

    private void saveProjects() {
        for (Project project : projectList) {
            // project 객체에 저장된 값을 꺼내 파일로 출력한다.
        }
    }

    private void saveBoards() {
        for (Board board : boardList) {
            //board 객체에 저장된 값을 꺼내 파일로 출력한다.
        }
    }


}