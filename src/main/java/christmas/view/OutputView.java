package christmas.view;

import static christmas.view.ViewMessage.*;

import christmas.domain.Bill;
import christmas.domain.event.Benefits;
import christmas.domain.event.giveaway.Giveaway;

public class OutputView {

    private static final int MONTH = 12;
    private static final int MIN_AMOUNT = 0;
    private static final String NO_GIVEAWAY = "없음";

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printReadDate() {
        System.out.printf(READ_DATE.getMessage(), MONTH, MONTH);
    }

    public void printReadMenu() {
        System.out.printf(READ_MENU.getMessage());
    }

    public void printResult(Bill bill) {
        printOrderMenu(bill);
        printNoDiscountAmount(bill);
        printGiveaway(bill);
        printBenefits(bill);
        printBenefitsAmount(bill);
        printAmountOfPayment(bill);
        printBadge(bill);
    }

    private void printOrderMenu(Bill bill) {
        System.out.printf(EVENT_PREVIEW.getMessage(), MONTH, bill.getDate());
        System.out.printf(ORDER_MENU.getMessage());
        bill.getOrderConfirmation().getOrderConfirmation()
                .forEach(order -> System.out.printf(NAME_AND_NUMBER.getMessage(),
                        order.getMenu().getName(), order.getCount()));
    }

    private void printNoDiscountAmount(Bill bill) {
        System.out.printf(TOTAL_AMOUNT.getMessage());
        System.out.printf(CURRENCY_UNIT.getMessage(),
                bill.getOrderConfirmation().getTotalPrice());
    }

    private void printGiveaway(Bill bill) {
        System.out.printf(GIVEAWAY.getMessage());
        Giveaway giveaway = bill.getBenefits().getGiveaway();
        if (giveaway.name().equals(NO_GIVEAWAY)) {
            System.out.printf(NONE.getMessage());
            return;
        }
        System.out.printf(NAME_AND_NUMBER.getMessage(),
                giveaway.name(), giveaway.quantity());
    }

    private void printBenefits(Bill bill) {
        System.out.printf(BENEFIT_DETAILS.getMessage());
        Benefits benefits = bill.getBenefits();
        if (benefits.getTotalDiscount() == MIN_AMOUNT) {
            System.out.printf(NONE.getMessage());
            return;
        }
        for (int i = 0; i < benefits.getEventDiscount().size(); i++) {
            System.out.printf(NAME_AND_CURRENCY_UNIT.getMessage(),
                    benefits.getEventNames().get(i),
                    benefits.getEventDiscount().get(i));
        }
    }

    private void printBenefitsAmount(Bill bill) {
        System.out.printf(TOTAL_DISCOUNT_AMOUNT.getMessage());
        int totalDiscount = bill.getBenefits().getTotalDiscount();
        if (totalDiscount == MIN_AMOUNT) {
            System.out.printf(CURRENCY_UNIT.getMessage(), totalDiscount);
            return;
        }
        System.out.printf(MINUS_CURRENCY_UNIT.getMessage(), totalDiscount);
    }

    private void printAmountOfPayment(Bill bill) {
        System.out.printf(AMOUNT_OF_PAYMENT.getMessage());
        int totalDiscount =
                bill.getBenefits().getTotalDiscount() - bill.getBenefits().getGiveaway().price();
        System.out.printf(CURRENCY_UNIT.getMessage(),
                bill.getOrderConfirmation().getTotalPrice() - totalDiscount);
    }

    public void printBadge(Bill bill) {
        System.out.printf(EVENT_BADGE.getMessage(), MONTH);
        System.out.printf(bill.getBadge());
    }
}
