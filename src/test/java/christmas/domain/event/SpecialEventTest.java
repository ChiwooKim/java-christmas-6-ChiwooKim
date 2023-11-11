package christmas.domain.event;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SpecialEventTest {

    @ParameterizedTest
    @DisplayName("특별 할인")
    @CsvSource(value = {"3:1000", "4:0", "24:1000", "25:1000", "30:0"}, delimiter = ':')
    void discount(int date, int expected) {
        SpecialEvent specialEvent = DiscountEvent.getSpecialEvent();

        assertThat(specialEvent.discount(date)).isEqualTo(expected);
    }
}