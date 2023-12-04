package christmas.domain;

import static christmas.exception.EventException.*;

import christmas.domain.menu.Menu;
import christmas.domain.menu.MenuType;
import java.util.EnumMap;
import java.util.List;

public class Order {

    private static final int MENU_MIN_RANGE = 1;
    private static final int MENU_MAX_RANGE = 20;
    private static final int TOTAL_MAX_COUNT = 20;
    private final EnumMap<Menu, Integer> order = new EnumMap<>(Menu.class);

    private Order(List<String> menus) {
        menus.forEach(this::addMenu);
        validateOrder();
    }

    public static Order from(List<String> menus) {
        return new Order(menus);
    }

    private void addMenu(String menu) {
        String[] nameAndCount = menu.split("-");
        Menu menuName = Menu.from(nameAndCount[0]);
        int count = Integer.parseInt(nameAndCount[1]);
        validateMenu(menuName, count);
        order.put(menuName, count);
    }

    private void validateMenu(Menu menu, int count) {
        validateDuplication(menu);
        validateRange(count);
    }

    private void validateDuplication(Menu menu) {
        if (order.containsKey(menu)) {
            throw INVALID_MENU.makeException();
        }
    }

    private void validateRange(int count) {
        if (count < MENU_MIN_RANGE || MENU_MAX_RANGE < count) {
            throw INVALID_ORDER.makeException();
        }
    }

    private void validateOrder() {
        validateTotalCount();
        validateOnlyDrink();
    }

    private void validateTotalCount() {
        int totalMenuCount = order.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        if (TOTAL_MAX_COUNT < totalMenuCount) {
            throw INVALID_TOTAL_NUMBER_OF_MENUS.makeException();
        }
    }

    private void validateOnlyDrink() {
        boolean exist = order.keySet().stream()
                .dropWhile(menu -> menu.isDrink(MenuType.DRINK))
                .findAny()
                .isEmpty();
        if (exist) {
            throw INVALID_ORDER.makeException();
        }
    }
}
