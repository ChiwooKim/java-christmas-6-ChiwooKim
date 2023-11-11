package christmas.domain.event.badge;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BenefitAmountEventTest {

    @ParameterizedTest
    @DisplayName("배지 이벤트 - 금액에 따른 배지 체크")
    @CsvSource(value = {"0:없음", "5000:별", "10000:트리", "20000:산타"}, delimiter = ':')
    void giveBadge(int amount, String expected) {
        BenefitAmountEvent benefitAmountEvent = BadgeEvent.getBenefitAmountEvent();

        assertThat(benefitAmountEvent.giveBadge(amount)).isEqualTo(expected);
    }
}