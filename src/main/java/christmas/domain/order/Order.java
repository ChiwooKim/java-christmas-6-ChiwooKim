package christmas.domain.order;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;

public class Order {

    private final Menu menu;
    private final int count;

    public Order(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public int getPrice() {
        return menu.getPrice() * count;
    }

    public boolean isType(MenuType menuType) {
        return menu.isType(menuType);
    }

    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }
}
