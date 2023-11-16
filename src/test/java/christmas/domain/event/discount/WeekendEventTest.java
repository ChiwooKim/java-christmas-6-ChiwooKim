package christmas.domain.event.discount;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WeekendEventTest {

    @ParameterizedTest
    @DisplayName("주말 할인")
    @CsvSource(value = {"1:1:2023", "3:1:0", "7:0:0", "22:0:0", "30:2:4046"},
            delimiter = ':')
    void discount(int date, int number, int expected) {
        WeekendEvent weekendEvent = DiscountEvent.getWeekendEvent();

        assertThat(weekendEvent.discount(date, number)).isEqualTo(expected);
    }
}