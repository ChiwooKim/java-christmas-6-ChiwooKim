package christmas.domain.event.discount;

import java.util.Set;

public class SpecialEvent implements DiscountEvent {

    private static final Set<Integer> specialDays = Set.of(3, 10, 17, 24, 25, 31);
    private static final int SPECIAL_DAY_DISCOUNT_AMOUNT = 1000;
    private static final int NON_SPECIAL_DAY_DISCOUNT_AMOUNT = 0;

    public String getSpecialEventName() {
        return "특별 할인";
    }

    public int discount(int date) {
        if (specialDays.contains(date)) {
            return SPECIAL_DAY_DISCOUNT_AMOUNT;
        }
        return NON_SPECIAL_DAY_DISCOUNT_AMOUNT;
    }
}
