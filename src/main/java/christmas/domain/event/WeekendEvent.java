package christmas.domain.event;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class WeekendEvent implements DiscountEvent {

    private static final int DISCOUNT_AMOUNT_UNIT = 2023;
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private static final int NON_EVENT_DAY_DISCOUNT_AMOUNT = 0;

    public int discount(int date, int numberOfMainManus) {
        LocalDate localDate = LocalDate.of(YEAR, MONTH, date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String day = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREAN);

        if (weekend.contains(day)) {
            return DISCOUNT_AMOUNT_UNIT * numberOfMainManus;
        }
        return NON_EVENT_DAY_DISCOUNT_AMOUNT;
    }
}
