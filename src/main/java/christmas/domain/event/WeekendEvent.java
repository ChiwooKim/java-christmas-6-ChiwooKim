package christmas.domain.event;

public class WeekendEvent implements DiscountEvent {

    @Override
    public int discount() {
        return 0;
    }
}
