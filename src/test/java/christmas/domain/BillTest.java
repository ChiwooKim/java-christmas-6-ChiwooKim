package christmas.domain;


import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BillTest {

    @Test
    void calculate() {
        Bill bill = Bill.getBill();
        Map<String, Integer> orderInfo = new HashMap<>();
        orderInfo.put("해산물파스타", 2);
        orderInfo.put("레드와인", 1);
        orderInfo.put("초코케이크", 1);
        bill.calculate(orderInfo);

        assertThat(bill.getNumberOfDessert()).isEqualTo(1);
        assertThat(bill.getNumberOfMain()).isEqualTo(2);
        assertThat(bill.getTotalAmount()).isEqualTo(145000);
    }
}