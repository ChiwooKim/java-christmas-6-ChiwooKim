package christmas.domain.event.badge;

public class BenefitAmountEvent {

    private static final String STAR_BADGE = "별";
    private static final String TREE_BADGE = "트리";
    private static final String SANTA_BADGE = "산타";
    private static final String NONE = "없음";
    private static final int STAR_STANDARD_AMOUNT = 5000;
    private static final int TREE_STANDARD_AMOUNT = 10000;
    private static final int SANTA_STANDARD_AMOUNT = 20000;

    public String giveBadge(int benefitAmount) {
        if (benefitAmount < STAR_STANDARD_AMOUNT) {
            return NONE;
        }
        if (benefitAmount < TREE_STANDARD_AMOUNT) {
            return STAR_BADGE;
        }
        if (benefitAmount < SANTA_STANDARD_AMOUNT) {
            return TREE_BADGE;
        }
        return SANTA_BADGE;
    }
}
