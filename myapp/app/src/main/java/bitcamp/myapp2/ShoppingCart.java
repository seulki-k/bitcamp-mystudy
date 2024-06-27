package bitcamp.myapp2;

public class ShoppingCart {
    private Item[] items = new Item[10];
    private int itemCount;

    public void addItem(Item item) {
        if (itemCount >= items.length) {
            System.out.println("가계부 목록이 가득 찼습니다.");
            return;
        }
        items[itemCount] = item;
        itemCount++;
    }

    public void displayItems() {
        System.out.println("[가계부 목록]");
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            System.out.println("카테고리 " + item.getCategory()+ ", 날짜 : " + item.getDate() + ", 상품명 : "+ item.getName() + ", 합계 : "+item.getPrice());
        }
        System.out.println("지출 합계 : " + calculateTotalPrice());
    }
    private int calculateTotalPrice() {
        int totalPrice =0;
        for (int i = 0; i < itemCount; i++) {
            Item item = items[i];
            totalPrice += item.getPrice();
        }
        return  totalPrice;
    }
}
