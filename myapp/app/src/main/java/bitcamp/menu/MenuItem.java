package bitcamp.menu;

import java.util.Objects;

public class MenuItem implements Menu {

    private String title;

    @Override
    public void execute() {
        System.out.println(title);
    }

    public MenuItem(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof MenuItem menuItem)) return false;
        return Objects.equals(title, menuItem.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }


}
