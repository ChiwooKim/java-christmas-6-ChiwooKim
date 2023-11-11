package christmas.domain.event;

public interface DiscountEvent {

    public static DDayEvent getDDayEvent() {
        return new DDayEvent();
    }

    public static WeekdayEvent getWeekdayEvent() {
        return new WeekdayEvent();
    }

    public static WeekendEvent getWeekendEvent() {
        return new WeekendEvent();
    }

    public static SpecialEvent getSpecialEvent() {
        return new SpecialEvent();
    }
}
