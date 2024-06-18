package bitcamp.myapp.vo;

import java.time.LocalDate;

public class Board {
    private String title; //제목
    private String description; //내용
    private LocalDate dateWritten; //작성일
    private int viewCount;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateWritten() {
        return dateWritten;
    }

    public void setDateWritten(LocalDate date) {
        this.dateWritten = date;
    }

    public void increaseViewCount() {
        this.viewCount++;
    }


}
