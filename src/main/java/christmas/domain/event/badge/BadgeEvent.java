package christmas.domain.event.badge;

public interface BadgeEvent {

    static BenefitAmountEvent getBenefitAmountEvent() {
        return new BenefitAmountEvent();
    }
}
