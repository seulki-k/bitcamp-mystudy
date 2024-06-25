package bitcamp.myapp.vo;


import bitcamp.myapp.command.ArrayList;

public class Project {
    private static int seqNo; //하나의 변수 계속 생성 static 사용 정적변수
    private int no; //인스턴스를 계속 생성해야된다.
    private String title;
    private String description;
    private String startDate;
    private String endDate;
    ArrayList members = new ArrayList();

    public static int getSeqNo() {
        return ++seqNo;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList getMembers() {
        return members;
    }
}
