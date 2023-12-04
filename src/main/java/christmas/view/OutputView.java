package christmas.view;

import static christmas.view.ViewMessage.*;

import christmas.domain.EventDay;
import christmas.domain.Order;
import java.util.stream.Collectors;

public class OutputView {

    private static final int MONTH = 12;

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printReadDate() {
        System.out.printf(READ_DATE.getMessage(), MONTH, MONTH);
    }

    public void printReadMenu() {
        System.out.printf(READ_MENU.getMessage());
    }

    public void printOrderMenu(Order order, EventDay eventDay) {
        System.out.printf(EVENT_PREVIEW.getMessage(), MONTH, eventDay.getLocalDate().getDayOfMonth());
        System.out.printf(ORDER_MENU.getMessage());
        order.getOrder().keySet()
                .forEach(menu -> System.out.printf(NAME_AND_NUMBER.getMessage(),
                        menu.getName(), order.getOrder().get(menu)));
    }
}
