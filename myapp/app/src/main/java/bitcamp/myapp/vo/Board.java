package bitcamp.myapp.vo;

import java.util.Date;
import java.util.Objects;

public class Board {

    private static int seqNo; //하나의 변수 계속 생성 static 사용 정적변수
    private int no; //인스턴스를 계속 생성해야된다.
    private String title; //제목
    private String content; //내용
    private Date createdDate;
    private int viewCount;

    public Board() {

    }

    public Board(int no) {
        this.no = no;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Board board = (Board) object;
        return no == board.no;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(no);
    }

    public static int getSeqNo() {
        return ++seqNo;
    }

    public static void setSeqNo(int seqNo) {
        Board.seqNo = seqNo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


}
