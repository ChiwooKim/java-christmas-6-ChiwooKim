package christmas.domain.event;

public class WeekdayEvent implements DiscountEvent {

    @Override
    public int discount() {
        return 0;
    }
}
