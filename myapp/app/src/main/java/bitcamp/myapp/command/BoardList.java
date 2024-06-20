package bitcamp.myapp.command;

import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;

public class BoardList {
    private static final int MAX_SIZE = 100;
    private static int boardLength = 0;
    private static Board[] boards = new Board[MAX_SIZE];

    public static void add(Board board) {
        boards[boardLength++] = board;
    }

    public static Board delete(int boardNo) {
        Board deletedboard = BoardList.findByNo(boardNo);
        if (deletedboard == null) {
            return null;
        }
        //다음 값을 앞으로 당긴다.
        int index = BoardList.indexOf(deletedboard);
        for (int i = index + 1; i < boardLength; i++) {
            boards[i - 1] = boards[i];
        }
        boards[--boardLength] = null;
        return deletedboard;
    }

    public static Board[] toArray() {
        Board[] board = new Board[boardLength];
        for (int i = 0; i < board.length; i++) {
            board[i] = boards[i];
        }
        return board;
    }

    public static Board findByNo(int userNo) {
        for (int i = 0; i < boardLength; i++) {
            Board board = boards[i];
            if (board.getNo() == userNo) {
                return board;
            }
        }
        return null;
    }

    public static int indexOf(Board board) {
        for (int i = 0; i < boardLength; i++) {
            if (boards[i] == board) {
                return i;
            }
        }
        return -1;
    }
}
