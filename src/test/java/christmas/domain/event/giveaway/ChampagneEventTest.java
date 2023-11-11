package christmas.domain.event.giveaway;


import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChampagneEventTest {

    @Test
    @DisplayName("증정 이벤트 샴페인 제공 여부 확인")
    void give() {
        ChampagneEvent champagneEvent = GiveawayEvent.getChampagneEvent();
        Giveaway giveaway1 = champagneEvent.give(120000);
        Giveaway giveaway2 = champagneEvent.give(119999);

        assertThat(giveaway1.name()).isEqualTo("샴페인");
        assertThat(giveaway1.price()).isEqualTo(25000);
        assertThat(giveaway1.quantity()).isEqualTo(1);

        assertThat(giveaway2.name()).isEqualTo("없음");
        assertThat(giveaway2.price()).isEqualTo(0);
        assertThat(giveaway2.quantity()).isEqualTo(0);
    }
}