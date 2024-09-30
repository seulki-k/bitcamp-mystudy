package bitcamp.myapp.service;

import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.vo.AttachedFile;
import bitcamp.myapp.vo.Board;
import org.apache.ibatis.session.SqlSessionFactory;
import org.checkerframework.checker.signature.qual.BinaryNameOrPrimitiveType;
import org.springframework.stereotype.Component;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DefaultBoardService implements BoardService {

  private BoardDao boardDao;

  public DefaultBoardService(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Transactional //insert가 2개로 하나의 트랜잭션으로 묶음
  @Override
  public void add(Board board) throws Exception {
    boardDao.insert(board);
    if (board.getAttachedFiles().size() > 0) {
      boardDao.insertFiles(board);
    }
  }

  @Override
  public List<Board> list() throws Exception {
    return boardDao.list();
  }

  @Override
  public Board get(int boardNo) throws Exception {
    return boardDao.findBy(boardNo);
  }

  @Transactional
  public void increaseViewCount(int boardNo) throws Exception {
    Board board = boardDao.findBy(boardNo);
    if (board != null) {
      boardDao.updateViewCount(board.getNo(), board.getViewCount() + 1);
    }
  }

  @Transactional
  public boolean update(Board board) throws Exception {
    if (!boardDao.update(board)) {
      return false;
    }

    if (board.getAttachedFiles().size() > 0) {
      boardDao.insertFiles(board);
    }
    return true;
  }

  @Transactional
  public void delete(int boardNo) throws Exception {
    boardDao.deleteFiles(boardNo);
    boardDao.delete(boardNo);
  }

  public AttachedFile getAttachedFile(int fileNo) throws Exception {
    return boardDao.getFile(fileNo);
  }

  @Transactional
  public boolean deleteAttachedFile(int fileNo) throws Exception {
    if (!boardDao.deleteFile(fileNo)) {
      return false;
    }
    return true;
  }
}
