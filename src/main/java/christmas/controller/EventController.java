package christmas.controller;

import christmas.domain.EventDay;
import christmas.domain.Order;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventController {

    private final InputView inputView;
    private final OutputView outputView;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void hold() {
        EventDay eventDay = getEventDay();
        Order order = getMenus();
    }

    private EventDay getEventDay() {
        outputView.printReadDate();
        while (true) {
            try {
                int date = inputView.readDate();
                return EventDay.from(date);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }

    private Order getMenus() {
        outputView.printReadMenu();
        while (true) {
            try {
                List<String> menus = inputView.readMenus();
                return Order.from(menus);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
