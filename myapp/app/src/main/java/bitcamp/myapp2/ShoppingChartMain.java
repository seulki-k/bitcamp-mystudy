package bitcamp.myapp2;

import java.util.Scanner;

public class ShoppingChartMain {
    static String[] menus = {"날짜", "항목", "가격", "비고"};

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        cart.addItem(Prompt.input());
        cart.displayItems();

    }

}
