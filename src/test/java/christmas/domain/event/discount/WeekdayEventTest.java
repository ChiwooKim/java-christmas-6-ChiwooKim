package christmas.domain.event.discount;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WeekdayEventTest {

    @ParameterizedTest
    @DisplayName("평일 할인")
    @CsvSource(value = {"1:2:0", "3:1:2023", "7:0:0", "25:2:4046", "30:0:0"},
            delimiter = ':')
    void discount(int date, int number, int expected) {
        WeekdayEvent weekdayEvent = DiscountEvent.getWeekdayEvent();

        assertThat(weekdayEvent.discount(date, number)).isEqualTo(expected);
    }
}