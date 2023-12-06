package christmas.service;

import christmas.domain.Bill;
import christmas.domain.EventDay;
import christmas.domain.event.Badge;
import christmas.domain.event.Benefits;
import christmas.domain.order.Orders;
import christmas.domain.order.OrderConfirmation;
import java.util.ArrayList;
import java.util.List;

public class EventService {
    public OrderConfirmation confirmOrder(Orders orders) {
        return orders.confirmOrder();
    }

    public Bill getBenefits(EventDay eventDay, OrderConfirmation orderConfirmation) {
        List<String> details = new ArrayList<>();
        Benefits benefits = Benefits.of(eventDay, orderConfirmation);
        String badge = Badge.getBadge(benefits.getTotalDiscount());
        return Bill.of(eventDay, orderConfirmation, benefits, badge);
    }
}
