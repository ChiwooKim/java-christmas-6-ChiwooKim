package christmas.domain.event.discount;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DDayEventTest {

    @ParameterizedTest
    @DisplayName("d-day 할인")
    @CsvSource(value = {"1:1000", "25:3400", "26:0", "31:0"}, delimiter = ':')
    void discount(int input, int expected) {
        DDayEvent dDayEvent = DiscountEvent.getDDayEvent();

        assertThat(dDayEvent.discount(input)).isEqualTo(expected);
    }
}