package christmas.domain.event.discount;

import christmas.domain.EventDay;
import christmas.domain.menu.MenuType;
import christmas.domain.order.OrderConfirmation;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Set;

public class WeekendEvent {

    private static final String EVENT_NAME = "주말 할인";
    private static final int DISCOUNT_AMOUNT_UNIT = 2023;
    private static final int NON_EVENT_DAY_DISCOUNT_AMOUNT = 0;
    private final Set<String> weekend = Set.of("금", "토");

    public String getEventName() {
        return EVENT_NAME;
    }

    public int discount(EventDay eventDay, OrderConfirmation orderConfirmation) {
        DayOfWeek dayOfWeek = eventDay.getLocalDate().getDayOfWeek();
        String day = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);

        if (weekend.contains(day)) {
            return DISCOUNT_AMOUNT_UNIT *
                    orderConfirmation.getTotalCountOfMenuType(MenuType.MAIN);
        }
        return NON_EVENT_DAY_DISCOUNT_AMOUNT;
    }
}
