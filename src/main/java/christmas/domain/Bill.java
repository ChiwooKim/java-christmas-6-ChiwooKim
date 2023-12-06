package christmas.domain;

import christmas.domain.event.Benefits;
import christmas.domain.order.OrderConfirmation;

public class Bill {

    private final int date;
    private final OrderConfirmation orderConfirmation;
    private final Benefits benefits;
    private final String badge;

    private Bill(int date, OrderConfirmation orderConfirmation, Benefits benefits, String badge) {
        this.date = date;
        this.orderConfirmation = orderConfirmation;
        this.benefits = benefits;
        this.badge = badge;
    }

    public static Bill of(EventDay eventDay, OrderConfirmation orderConfirmation,
                                 Benefits benefits, String badge) {
        int date = eventDay.getLocalDate().getDayOfMonth();
        return new Bill(date, orderConfirmation, benefits, badge);
    }

    public int getDate() {
        return date;
    }

    public OrderConfirmation getOrderConfirmation() {
        return orderConfirmation;
    }

    public Benefits getBenefits() {
        return benefits;
    }

    public String getBadge() {
        return badge;
    }
}
