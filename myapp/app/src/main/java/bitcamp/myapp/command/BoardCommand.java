package bitcamp.myapp.command;

import bitcamp.myapp.util.Prompt;
import bitcamp.myapp.vo.Board;

import java.time.LocalDate;

public class BoardCommand {
    private static final int MAX_SIZE = 100;
    private static int boardLength = 0;
    private static Board[] boards = new Board[MAX_SIZE];

    public static void executeBoardCommand(String command) {
        System.out.printf("[%s]\n", command);
        switch (command) {
            case "등록":
                addBoard();
                break;
            case "목록":
                listBoard();
                break;
            case "조회":
                viewBoard();
                break;
            case "변경":
                updateBoard();
                break;
            case "삭제":
                deleteBoard();
                break;
        }
    }

    private static void addBoard() {
        Board board = new Board();
        board.setTitle(Prompt.input("제목?"));
        board.setDescription(Prompt.input("내용?"));
        board.setDateWritten(LocalDate.now());
        board.setViewCount(0);
        boards[boardLength++] = board;
        System.out.println("등록했습니다.");
    }

    private static void listBoard() {
        System.out.println("번호 제목 작성일 조회수");
        for (int i = 0; i < boardLength; i++) {
            Board board = boards[i];
            System.out.printf("%d %s %s %s %s\n", (i + 1), board.getTitle(), board.getDescription(), board.getDateWritten(), board.getViewCount());
        }
    }

    private static void viewBoard() {
        int boardNo = Prompt.inputInt("게시판 번호?");
        if (boardNo < 1 || boardNo > boardLength) {
            System.out.println("없는 프로젝트입니다.");
            return;
        }
        Board board = boards[boardNo - 1];
        board.increaseViewCount();
        System.out.printf("제목 : %s\n", board.getTitle());
        System.out.printf("내용 : %s\n", board.getDescription());
        System.out.printf("작성일 : %s\n", board.getDateWritten());
        System.out.printf("조회수 : %s\n", board.getViewCount());
    }

    private static void deleteBoard() {
        int boardNo = Prompt.inputInt("게시판 번호?");
        if (boardNo < 1 || boardNo > boardLength) {
            System.out.println("없는 회원입니다.");
            return;
        }
        //다음 값을 앞으로 당긴다.
        for (int i = boardNo; i < boardLength; i++) {
            boards[i - 1] = boards[i];
        }
        boards[--boardLength] = null;
        System.out.println("삭제했습니다.");
    }

    private static void updateBoard() {
        int boardNo = Prompt.inputInt("게시판 번호?");
        if (boardNo < 1 || boardNo > boardLength) {
            System.out.println("없는 게시판입니다.");
            return;
        }
        Board board = boards[boardNo - 1];
        board.setTitle(Prompt.input("게시판명(%s)\n", board.getTitle()));
        board.setDescription(Prompt.input("내용(%s)\n", board.getDescription()));
        board.setDateWritten(LocalDate.now());

        System.out.println("변경하였습니다.");

    }
}
