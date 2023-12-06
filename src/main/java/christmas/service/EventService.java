package christmas.service;

import christmas.domain.Orders;
import christmas.domain.menu.OrderConfirmation;

public class EventService {

    public OrderConfirmation confirmOrder(Orders orders) {
        return orders.confirmOrder();
    }
}
