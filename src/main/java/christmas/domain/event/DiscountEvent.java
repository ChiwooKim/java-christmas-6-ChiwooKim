package christmas.domain.event;

public interface DiscountEvent {

    int discount();

    public static DiscountEvent getDDayEvent() {
        return new DDayEvent();
    }

    public static DiscountEvent getWeekdayEvent() {
        return new WeekdayEvent();
    }

    public static DiscountEvent getWeekendEvent() {
        return new WeekendEvent();
    }

    public static DiscountEvent getSpecialEvent() {
        return new SpecialEvent();
    }
}
