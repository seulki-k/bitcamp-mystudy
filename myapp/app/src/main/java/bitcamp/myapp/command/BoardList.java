package bitcamp.myapp.command;

import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;

public class BoardList {
    private final static int MAX_SIZE = 100;
    private int boardLength = 0;
    private Board[] boards = new Board[MAX_SIZE];

    public void add(Board board) {
        this.boards[boardLength++] = board;
    }

    public Board delete(int boardNo) {
        BoardList boardList = new BoardList();
        Board deletedboard = boardList.findByNo(boardNo);
        if (deletedboard == null) {
            return null;
        }
        //다음 값을 앞으로 당긴다.
        int index = boardList.indexOf(deletedboard);
        for (int i = index + 1; i < boardLength; i++) {
            boards[i - 1] = boards[i];
        }
        boards[--boardLength] = null;
        return deletedboard;
    }

    public Board[] toArray() {
        Board[] board = new Board[boardLength];
        for (int i = 0; i < board.length; i++) {
            board[i] = this.boards[i];
        }
        return board;
    }

    public Board findByNo(int userNo) {
        for (int i = 0; i < this.boardLength; i++) {
            Board board = this.boards[i];
            if (board.getNo() == userNo) {
                return board;
            }
        }
        return null;
    }

    public int indexOf(Board board) {
        for (int i = 0; i < this.boardLength; i++) {
            if (this.boards[i] == board) {
                return i;
            }
        }
        return -1;
    }
}
