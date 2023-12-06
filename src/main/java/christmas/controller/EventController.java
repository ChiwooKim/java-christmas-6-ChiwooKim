package christmas.controller;

import christmas.domain.Bill;
import christmas.domain.EventDay;
import christmas.domain.order.Orders;
import christmas.domain.order.OrderConfirmation;
import christmas.service.EventService;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class EventController {

    private final InputView inputView;
    private final OutputView outputView;
    private final EventService eventService;

    public EventController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.eventService = new EventService();
    }

    public void hold() {
        EventDay eventDay = getEventDay();
        OrderConfirmation orderConfirmation = getOrder();
        Bill bill = eventService.getBenefits(eventDay, orderConfirmation);
        outputView.printResult(bill);
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

    private OrderConfirmation getOrder() {
        outputView.printReadMenu();
        while (true) {
            try {
                List<String> menus = inputView.readMenus();
                return eventService.confirmOrder(Orders.from(menus));
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e);
            }
        }
    }
}
