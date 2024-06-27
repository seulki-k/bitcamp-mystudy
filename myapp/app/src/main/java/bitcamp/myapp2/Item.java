package bitcamp.myapp2;

public class Item {
    private String category; // 항목
    private String name; // 비고
    private int price; //가격
    private String Date; //날짜

    public String getDate() {
        return Date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Item(String Date, String category, int price, String name) {
        this.category = category;
        this.Date = Date;
        this.name = name;
        this.price = price;

    }

    public String getName() {
        return name;
    }


}
