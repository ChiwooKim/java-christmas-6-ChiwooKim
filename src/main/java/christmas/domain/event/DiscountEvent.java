package christmas.domain.event;

import java.util.Set;

public interface DiscountEvent {

    Set<String> weekday = Set.of("일", "월", "화", "수", "목");
    Set<String> weekend = Set.of("금", "토");

    static DDayEvent getDDayEvent() {
        return new DDayEvent();
    }

    static WeekdayEvent getWeekdayEvent() {
        return new WeekdayEvent();
    }

    static WeekendEvent getWeekendEvent() {
        return new WeekendEvent();
    }

    static SpecialEvent getSpecialEvent() {
        return new SpecialEvent();
    }
}
