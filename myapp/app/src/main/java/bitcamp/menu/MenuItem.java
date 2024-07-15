package bitcamp.menu;

import java.util.Objects;

public class MenuItem extends AbstractMenu {

    @Override
    public void execute() {
        System.out.println(title);
    }

    public MenuItem(String title) {
        super(title);
    }


}
