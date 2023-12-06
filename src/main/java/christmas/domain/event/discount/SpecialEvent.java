package christmas.domain.event.discount;

import christmas.domain.EventDay;
import java.util.Set;

public class SpecialEvent {

    private static final String EVENT_NAME = "특별 할인";
    private static final Set<Integer> specialDays = Set.of(3, 10, 17, 24, 25, 31);
    private static final int SPECIAL_DAY_DISCOUNT_AMOUNT = 1000;
    private static final int NON_SPECIAL_DAY_DISCOUNT_AMOUNT = 0;

    public String getEventName() {
        return EVENT_NAME;
    }

    public int discount(EventDay eventDay) {
        int date = eventDay.getLocalDate().getDayOfMonth();
        if (specialDays.contains(date)) {
            return SPECIAL_DAY_DISCOUNT_AMOUNT;
        }
        return NON_SPECIAL_DAY_DISCOUNT_AMOUNT;
    }
}
