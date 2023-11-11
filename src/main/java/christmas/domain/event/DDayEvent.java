package christmas.domain.event;

public class DDayEvent implements DiscountEvent {

    @Override
    public int discount() {
        return 0;
    }
}
