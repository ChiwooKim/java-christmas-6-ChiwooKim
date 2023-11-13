package christmas.domain.event.giveaway;

public class ChampagneEvent implements GiveawayEvent {

    private static final int STANDARD_AMOUNT = 120000;
    private static final String GIVEAWAY_NAME = "샴페인";
    private static final int GIVEAWAY_AMOUNT = 25000;
    private static final int GIVEAWAY_QUANTITY = 1;
    private static final String NO_GIVEAWAY = "없음";
    private static final int LESS_THAN_STANDARD_AMOUNT = 0;
    private static final int NO_QUANTITY = 0;

    public String getChampagneEventName() {
        return "증정 이벤트";
    }

    public Giveaway give(int amount) {
        if (amount >= STANDARD_AMOUNT) {
            return new Giveaway(GIVEAWAY_NAME, GIVEAWAY_AMOUNT, GIVEAWAY_QUANTITY);
        }
        return new Giveaway(NO_GIVEAWAY, LESS_THAN_STANDARD_AMOUNT, NO_QUANTITY);
    }
}
