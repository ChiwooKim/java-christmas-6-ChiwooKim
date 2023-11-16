package christmas.controller;

import christmas.domain.BenefitDetails;
import christmas.domain.Bill;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.Map;

public class EventController {

    private final InputView inputView;
    private final OutputView outputView;

    public EventController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void hold() {
        int date = getDate();
        Map<String, Integer> orderInfo = getOrder(date);
        Bill bill = getBill(orderInfo);
        BenefitDetails benefitDetails = getBenefitDetails(date, bill);
        getResult(bill, benefitDetails);
    }

    private void getResult(Bill bill, BenefitDetails benefitDetails) {
        int paymentAmount = bill.getTotalAmount() - benefitDetails.getTotalDiscountAmount() +
                benefitDetails.getGiveaway().price();
        outputView.printAmountOfPayment(paymentAmount);
        outputView.printEventBadge(benefitDetails);
    }

    private BenefitDetails getBenefitDetails(int date, Bill bill) {
        BenefitDetails benefitDetails = BenefitDetails.getBenefitDetails();
        benefitDetails.receive(date, bill);

        outputView.printGiveaway(benefitDetails);
        outputView.printBenefitDetails(benefitDetails);
        outputView.printTotalDiscountAmount(benefitDetails);
        return benefitDetails;
    }

    private Bill getBill(Map<String, Integer> orderInfo) {
        Bill bill = Bill.getBill();
        bill.calculate(orderInfo);
        outputView.printTotalAmount(bill.getTotalAmount());
        return bill;
    }

    private Map<String, Integer> getOrder(int date) {
        outputView.printReadMenu();
        Map<String, Integer> orderInfo = inputView.readMenu();
        outputView.printEventPreview(date);
        outputView.printOrderMenu(orderInfo);
        return orderInfo;
    }

    private int getDate() {
        outputView.printReadDate();
        return inputView.readDate();
    }
}
