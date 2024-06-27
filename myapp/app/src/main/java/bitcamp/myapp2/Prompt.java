package bitcamp.myapp2;

import java.util.Scanner;

public class Prompt {

    public static Item input() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <ShoppingChartMain.menus.length ; i++) {
            System.out.print(ShoppingChartMain.menus[i] + " : ");
        }

        Item item = new Item("a","A",3,"A");
       scanner.nextLine();
        return item;
    }
}
