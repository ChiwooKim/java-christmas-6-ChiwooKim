package christmas.domain.event.discount;

import christmas.domain.EventDay;
import christmas.domain.menu.MenuType;
import christmas.domain.order.OrderConfirmation;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Set;

public class WeekdayEvent {

    private static final String EVENT_NAME = "평일 할인";
    private static final int DISCOUNT_AMOUNT_UNIT = 2023;
    private static final int NON_EVENT_DAY_DISCOUNT_AMOUNT = 0;
    private final Set<String> weekday = Set.of("일", "월", "화", "수", "목");

    public String getEventName() {
        return EVENT_NAME;
    }

    public int discount(EventDay eventDay, OrderConfirmation orderConfirmation) {
        DayOfWeek dayOfWeek = eventDay.getLocalDate().getDayOfWeek();
        String day = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);

        if (weekday.contains(day)) {
            return DISCOUNT_AMOUNT_UNIT *
                    orderConfirmation.getTotalCountOfMenuType(MenuType.DESSERT);
        }
        return NON_EVENT_DAY_DISCOUNT_AMOUNT;
    }
}
