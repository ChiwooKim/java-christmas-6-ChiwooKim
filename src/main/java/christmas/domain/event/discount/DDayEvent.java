package christmas.domain.event.discount;

public class DDayEvent implements DiscountEvent {

    private static final int FIRST_DAY_DATE = 1;
    private static final int FIRST_DAY_DISCOUNT = 1000;
    private static final int ADDITIONAL_DISCOUNT_AMOUNT = 100;
    private static final int LAST_EVENT_DAY = 25;
    private static final int NON_EVENT_DAY_DISCOUNT_AMOUNT = 0;

    public String getDDayEventName() {
        return "크리스마스 디데이 할인";
    }

    public int discount(int date) {
        if (date > LAST_EVENT_DAY) {
            return NON_EVENT_DAY_DISCOUNT_AMOUNT;
        }
        return FIRST_DAY_DISCOUNT + ((date - FIRST_DAY_DATE) * ADDITIONAL_DISCOUNT_AMOUNT);
    }
}
