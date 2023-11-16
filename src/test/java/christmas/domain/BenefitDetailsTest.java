package christmas.domain;


import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BenefitDetailsTest {

    private Map<String, Integer> orderInfo;
    private Bill bill;
    private BenefitDetails benefitDetails;

    @BeforeEach
    void beforeEach() {
        this.orderInfo = new HashMap<>();
        this.bill = Bill.getBill();
        this.benefitDetails = BenefitDetails.getBenefitDetails();
    }

    @Test
    @DisplayName("혜택 내역 확인 - 적용 이벤트가 있는 경우")
    void receiveTest1() {
        orderInfo.put("티본스테이크", 1);
        orderInfo.put("바비큐립", 1);
        orderInfo.put("초코케이크", 2);
        orderInfo.put("제로콜라", 1);
        bill.calculate(orderInfo);
        benefitDetails.receive(3, bill);

        assertThat(benefitDetails.getDiscountNames())
                .isEqualTo(List.of("크리스마스 디데이 할인", "평일 할인", "특별 할인", "증정 이벤트"));
        assertThat(benefitDetails.getTotalDiscountAmount()).isEqualTo(31246);
        assertThat(benefitDetails.getGiveaway().name()).isEqualTo("샴페인");
        assertThat(benefitDetails.getBadge()).isEqualTo("산타");
    }

    @Test
    @DisplayName("혜택 내역 확인 - 적용 이벤트가 없는 경우")
    void receiveTest2() {
        orderInfo.put("타파스", 1);
        orderInfo.put("제로콜라", 1);
        bill.calculate(orderInfo);
        benefitDetails.receive(26, bill);

        assertThat(benefitDetails.getDiscountNames()).isEmpty();
        assertThat(benefitDetails.getTotalDiscountAmount()).isEqualTo(0);
        assertThat(benefitDetails.getGiveaway().name()).isEqualTo("없음");
        assertThat(benefitDetails.getBadge()).isEqualTo("없음");
    }
}