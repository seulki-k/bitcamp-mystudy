package bitcamp.myapp.vo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

// Serializable 인터페이스
// - 추상 메서드가 없다.
// - 직렬화/역직렬화 승인한다는 표시
// - 유사한 예) Cloneable 인터페이스
public class Board implements Serializable, SequenceNo {

    private static int seqNo;

    private int no;
    private String title;
    private String content;
    private Date createdDate;
    private int viewCount;

    public static void initSeqNo(int no) {
        seqNo = no;
    }

    public Board() {

    }

    public Board(int no) {
        this.no = no;
    }

    public static int getNextSeqNo() {
        return ++seqNo;
    }


    public static Board valueOf(String csv) {
        String[] values = csv.split(",");
        Board board = new Board();
        board.setNo(Integer.valueOf(values[0]));
        board.setTitle(values[1]);
        board.setContent(values[2]);

        board.setCreatedDate(new Date(Long.valueOf(values[3])));
        board.setViewCount(Integer.valueOf(values[4]));
        return board;
    }

    @Override
    public String toString() {
        return "Board{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdDate=" + createdDate +
                ", viewCount=" + viewCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board board = (Board) o;
        return no == board.no;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(no);
    }

    @Override
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }
}
