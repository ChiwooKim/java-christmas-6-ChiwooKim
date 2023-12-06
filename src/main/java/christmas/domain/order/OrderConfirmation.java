package christmas.domain.order;

import christmas.domain.menu.MenuType;
import java.util.Collections;
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

    public int getTotalCountOfMenuType(MenuType menuType) {
        return orderConfirmation.stream()
                .filter(Order -> Order.isType(menuType))
                .mapToInt(Order::getCount)
                .sum();
    }

    public List<Order> getOrderConfirmation() {
        return Collections.unmodifiableList(orderConfirmation);
    }
}
