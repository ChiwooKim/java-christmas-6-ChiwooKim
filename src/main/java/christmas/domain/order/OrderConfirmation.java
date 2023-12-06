package christmas.domain.order;

import christmas.domain.order.Order;
import java.util.List;

public class OrderConfirmation {

    private final List<Order> orderConfirmation;

    public OrderConfirmation(List<Order> confirmation) {
        this.orderConfirmation = confirmation;
    }

    public int getTotalPrice() {
        return orderConfirmation.stream()
                .mapToInt(Order::getPrice)
                .sum();
    }
}
