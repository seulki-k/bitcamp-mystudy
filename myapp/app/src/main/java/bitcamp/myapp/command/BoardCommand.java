package bitcamp.myapp.command;

import bitcamp.myapp.util.ArrayList;
import bitcamp.myapp.util.LinkedList;
import bitcamp.myapp.util.Prompt;
import bitcamp.myapp.vo.Board;

import java.util.Date;

public class BoardCommand {

    LinkedList boardList = new LinkedList();

    public void executeBoardCommand(String command) {
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

    private void addBoard() {
        Board board = new Board();
        board.setTitle(Prompt.input("제목?"));
        board.setContent(Prompt.input("내용?"));
        board.setCreatedDate(new Date());
        board.setViewCount(0);
        board.setNo(Board.getSeqNo());
        boardList.add(board);
        System.out.println("등록했습니다.");
    }

    private void listBoard() {
        System.out.println("번호 제목 작성일 조회수");
        for (Object obj : boardList.toArray()) {
            Board board = (Board) obj;
            System.out.printf("%d %s %tD %s\n", board.getNo(), board.getTitle(), board.getCreatedDate(), board.getViewCount());
        }
    }

    private void viewBoard() {
        int boardNo = Prompt.inputInt("게시판 번호?");
        Board board = (Board) boardList.get(boardList.indexOf(new Board(boardNo)));
        if (board == null) {
            System.out.println("없는 게시판입니다.");
            return;
        }
        board.setViewCount(board.getViewCount() + 1);
        System.out.printf("제목 : %s\n", board.getTitle());
        System.out.printf("내용 : %s\n", board.getContent());
        System.out.printf("작성일 : %1$tY-%1$tm-%1$td  %1$tH : %1$tM : %1$tS\n", board.getCreatedDate());
        System.out.printf("조회수 : %s\n", board.getViewCount());
    }

    private void deleteBoard() {
        int boardNo = Prompt.inputInt("게시판 번호?");
        Board deletedBoard = (Board) boardList.get(boardList.indexOf(new Board(boardNo)));
        if (deletedBoard != null) {
            boardList.remove(boardList.indexOf(deletedBoard));
            System.out.printf("'%s' 게시판 삭제했습니다.\n", deletedBoard.getTitle());
        } else
            System.out.println("없는 게시판입니다.");
    }

    private void updateBoard() {
        int boardNo = Prompt.inputInt("게시판 번호?");
        Board board = (Board) boardList.get(boardList.indexOf(new Board(boardNo)));
        if (board == null) {
            System.out.println("없는 게시판입니다.");
            return;
        }
        board.setViewCount(board.getViewCount() + 1);
        board.setTitle(Prompt.input("게시판명(%s)\n", board.getTitle()));
        board.setContent(Prompt.input("내용(%s)\n", board.getContent()));
        System.out.println("변경하였습니다.");
    }
}
