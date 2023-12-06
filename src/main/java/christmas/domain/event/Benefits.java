package christmas.domain.event;

import christmas.domain.EventDay;
import christmas.domain.event.discount.DDayEvent;
import christmas.domain.event.discount.SpecialEvent;
import christmas.domain.event.discount.WeekdayEvent;
import christmas.domain.event.discount.WeekendEvent;
import christmas.domain.event.giveaway.ChampagneEvent;
import christmas.domain.event.giveaway.Giveaway;
import christmas.domain.order.OrderConfirmation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Benefits {

    private static final int MIN_AMOUNT_FOR_BENEFITS = 10000;
    private static final int MIN_AMOUNT = 0;
    private final List<String> eventNames;
    private final List<Integer> eventDiscount;
    private Giveaway giveaway;

    private Benefits(EventDay eventDay, OrderConfirmation orderConfirmation) {
        this.eventNames = new ArrayList<>();
        this.eventDiscount = new ArrayList<>();
        participateEvent(eventDay, orderConfirmation);
        getGiveawayInfo(orderConfirmation);
    }

    private void getGiveawayInfo(OrderConfirmation orderConfirmation) {
        ChampagneEvent champagneEvent = new ChampagneEvent();
        this.giveaway = champagneEvent.give(orderConfirmation.getTotalPrice());
        if (giveaway.quantity() > MIN_AMOUNT) {
            eventNames.add(champagneEvent.getChampagneEventName());
            eventDiscount.add(giveaway.price());
        }
    }

    public static Benefits of(EventDay eventDay, OrderConfirmation orderConfirmation) {
        return new Benefits(eventDay, orderConfirmation);
    }

    private void participateEvent(EventDay eventDay, OrderConfirmation orderConfirmation) {
        if (orderConfirmation.getTotalPrice() > MIN_AMOUNT_FOR_BENEFITS) {
            getDiscount(eventDay, orderConfirmation);
        }
    }

    private void getDiscount(EventDay eventDay, OrderConfirmation orderConfirmation) {
        getDDayEventInfo(eventDay);
        getWeekdayEventInfo(eventDay, orderConfirmation);
        getWeekendEventInfo(eventDay, orderConfirmation);
        getSpecialEventInfo(eventDay);
    }

    private void getSpecialEventInfo(EventDay eventDay) {
        SpecialEvent specialEvent = new SpecialEvent();
        int discount = specialEvent.discount(eventDay);
        if (discount > MIN_AMOUNT) {
            eventNames.add(specialEvent.getEventName());
            eventDiscount.add(discount);
        }
    }

    private void getWeekendEventInfo(EventDay eventDay, OrderConfirmation orderConfirmation) {
        WeekendEvent weekendEvent = new WeekendEvent();
        int discount = weekendEvent.discount(eventDay, orderConfirmation);
        if (discount > MIN_AMOUNT) {
            eventNames.add(weekendEvent.getEventName());
            eventDiscount.add(discount);
        }
    }

    private void getWeekdayEventInfo(EventDay eventDay, OrderConfirmation orderConfirmation) {
        WeekdayEvent weekdayEvent = new WeekdayEvent();
        int discount = weekdayEvent.discount(eventDay, orderConfirmation);
        if (discount > MIN_AMOUNT) {
            eventNames.add(weekdayEvent.getEventName());
            eventDiscount.add(discount);
        }
    }

    private void getDDayEventInfo(EventDay eventDay) {
        DDayEvent dDayEvent = new DDayEvent();
        int discount = dDayEvent.discount(eventDay);
        if (discount > MIN_AMOUNT) {
            eventNames.add(dDayEvent.getEventName());
            eventDiscount.add(discount);
        }
    }

    public int getTotalDiscount() {
        return eventDiscount.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<String> getEventNames() {
        return Collections.unmodifiableList(eventNames);
    }

    public List<Integer> getEventDiscount() {
        return Collections.unmodifiableList(eventDiscount);
    }

    public Giveaway getGiveaway() {
        return giveaway;
    }
}
