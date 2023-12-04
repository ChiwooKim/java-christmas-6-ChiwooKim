package christmas.domain;

import christmas.exception.EventException;
import java.time.LocalDate;

public class EventDay {

    private static final int DATE_MIN_RANGE = 1;
    private static final int DATE_MAX_RANGE = 31;
    private static final int YEAR = 2023;
    private static final int MONTH = 12;
    private final LocalDate localDate;

    private EventDay(int date) {
        validateRange(date);
        this.localDate = LocalDate.of(YEAR, MONTH, date);
    }

    public static EventDay from(int date) {
        return new EventDay(date);
    }

    private void validateRange(int date) {
        if (date < DATE_MIN_RANGE || DATE_MAX_RANGE < date) {
            throw EventException.INVALID_DATE.makeException();
        }
    }
}
