package christmas.domain;

import christmas.domain.event.badge.BadgeEvent;
import christmas.domain.event.discount.DDayEvent;
import christmas.domain.event.discount.DiscountEvent;
import christmas.domain.event.discount.SpecialEvent;
import christmas.domain.event.discount.WeekdayEvent;
import christmas.domain.event.discount.WeekendEvent;
import christmas.domain.event.giveaway.ChampagneEvent;
import christmas.domain.event.giveaway.Giveaway;
import christmas.domain.event.giveaway.GiveawayEvent;
import java.util.ArrayList;
import java.util.List;

public class BenefitDetails {

    private static final int PARTICIPATION_CRITERIA = 10000;
    private static final int MIN_AMOUNT = 0;
    public static final int EVENT_START_DAY = 1;
    public static final int EVENT_LAST_DAY = 31;
    private final List<String> discountNames;
    private final List<Integer> discountAmount;
    private int totalDiscountAmount;
    private String badge;
    private Giveaway giveaway;

    public BenefitDetails() {
        this.discountNames = new ArrayList<>();
        this.discountAmount = new ArrayList<>();
    }

    public static BenefitDetails getBenefitDetails() {
        return new BenefitDetails();
    }

    public void receive(int date, Bill bill) {
        if (bill.getTotalAmount() >= PARTICIPATION_CRITERIA &&
                date >= EVENT_START_DAY && date <= EVENT_LAST_DAY) {
            getDiscountInfo(date, bill);
        }
        getGiveawayInfo(bill);
        this.totalDiscountAmount = discountAmount.stream().mapToInt(Integer::intValue).sum();
        this.badge = BadgeEvent.getBenefitAmountEvent().giveBadge(totalDiscountAmount);
    }

    private void getGiveawayInfo(Bill bill) {
        ChampagneEvent champagneEvent = GiveawayEvent.getChampagneEvent();
        this.giveaway = champagneEvent.give(bill.getTotalAmount());
        if (giveaway.quantity() > MIN_AMOUNT) {
            discountNames.add(champagneEvent.getChampagneEventName());
            discountAmount.add(giveaway.price());
        }
    }

    private void getDiscountInfo(int date, Bill bill) {
        getDDayEventInfo(date);
        getWeekdayEventInfo(date, bill.getNumberOfDessert());
        getWeekendEventInfo(date, bill.getNumberOfMain());
        getSpecialEventInfo(date);
    }

    private void getSpecialEventInfo(int date) {
        SpecialEvent specialEvent = DiscountEvent.getSpecialEvent();
        int discount = specialEvent.discount(date);
        if (discount > MIN_AMOUNT) {
            discountAmount.add(discount);
            discountNames.add(specialEvent.getSpecialEventName());
        }
    }

    private void getWeekendEventInfo(int date, int numberOfMain) {
        WeekendEvent weekendEvent = DiscountEvent.getWeekendEvent();
        int discount = weekendEvent.discount(date, numberOfMain);
        if (discount > MIN_AMOUNT) {
            discountAmount.add(discount);
            discountNames.add(weekendEvent.getWeekendEventName());
        }
    }

    private void getWeekdayEventInfo(int date, int numberOfDessert) {
        WeekdayEvent weekdayEvent = DiscountEvent.getWeekdayEvent();
        int discount = weekdayEvent.discount(date, numberOfDessert);
        if (discount > MIN_AMOUNT) {
            discountAmount.add(discount);
            discountNames.add(weekdayEvent.getWeekdayEventName());
        }
    }

    private void getDDayEventInfo(int date) {
        DDayEvent dDayEvent = DiscountEvent.getDDayEvent();
        int discount = dDayEvent.discount(date);
        if (discount > MIN_AMOUNT) {
            discountAmount.add(discount);
            discountNames.add(dDayEvent.getDDayEventName());
        }
    }

    public List<String> getDiscountNames() {
        return discountNames;
    }

    public List<Integer> getDiscountAmount() {
        return discountAmount;
    }

    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }

    public String getBadge() {
        return badge;
    }

    public Giveaway getGiveaway() {
        return giveaway;
    }
}
