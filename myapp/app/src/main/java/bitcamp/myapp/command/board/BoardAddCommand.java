package bitcamp.myapp.command.board;

import bitcamp.myapp.command.Command;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.User;
import bitcamp.util.Prompt;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class BoardAddCommand implements Command {

    private List<Integer> boardList;
    private Map<Integer, Board> boardMap;

    public BoardAddCommand(Map<Integer,Board> boardMap, List<Integer> boardNoList) {
        this.boardMap = boardMap;
        this.boardList = boardNoList;
    }

    @Override
    public void execute(String menuName) {

        Board board = new Board();
        board.setTitle(Prompt.input("제목?"));
        board.setContent(Prompt.input("내용?"));
        board.setCreatedDate(new Date());
        board.setNo(Board.getNextSeqNo());
        boardMap.put(board.getNo(), board);
        boardList.add(board.getNo());
    }

}
