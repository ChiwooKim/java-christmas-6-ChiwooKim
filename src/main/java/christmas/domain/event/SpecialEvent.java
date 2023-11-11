package christmas.domain.event;

public class SpecialEvent implements DiscountEvent {

    @Override
    public int discount() {
        return 0;
    }
}
