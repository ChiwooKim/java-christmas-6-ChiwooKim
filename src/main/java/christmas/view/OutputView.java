package christmas.view;

import static christmas.util.Constant.*;

import christmas.domain.BenefitDetails;
import java.util.Map;

public class OutputView {

    private static final int MIN_AMOUNT = 0;

    public void printReadDate() {
        System.out.printf(Message.READ_DATE.getMessage(), DECEMBER, DECEMBER);
    }

    public void printReadMenu() {
        System.out.println(Message.READ_MENU.getMessage());
    }

    public void printEventPreview(int date) {
        System.out.printf(Message.EVENT_PREVIEW.getMessage(), DECEMBER, date);
    }

    public void printOrderMenu(Map<String, Integer> orderInfo) {
        System.out.printf(Message.ORDER_MENU.getMessage());
        for (String menu : orderInfo.keySet()) {
            System.out.printf(Message.NAME_AND_NUMBER.getMessage(), menu, orderInfo.get(menu));
        }
    }

    public void printTotalAmount(int amount) {
        System.out.printf(Message.TOTAL_AMOUNT.getMessage());
        System.out.printf(Message.CURRENCY_UNIT.getMessage(), String.valueOf(amount)
                .replaceAll(AMOUNT_OUTPUT_CONVERT_PATTERN, DELIMITER_COMMA));
    }

    public void printGiveaway(BenefitDetails benefitDetails) {
        System.out.printf(Message.GIVEAWAY.getMessage());
        if (benefitDetails.getGiveaway().name().equals(Message.NONE.getMessage())) {
            System.out.println(Message.NONE.getMessage());
            return;
        }
        System.out.printf(Message.NAME_AND_NUMBER.getMessage(),
                benefitDetails.getGiveaway().name(),
                benefitDetails.getGiveaway().quantity());
    }

    public void printBenefitDetails(BenefitDetails benefitDetails) {
        System.out.printf(Message.BENEFIT_DETAILS.getMessage());
        if (benefitDetails.getTotalDiscountAmount() == MIN_AMOUNT) {
            System.out.println(Message.NONE.getMessage());
            return;
        }
        for (int i = 0; i < benefitDetails.getDiscountAmount().size(); i++) {
            System.out.printf(Message.NAME_AND_CURRENCY_UNIT.getMessage(),
                    benefitDetails.getDiscountNames().get(i),
                    String.valueOf(benefitDetails.getDiscountAmount().get(i))
                            .replaceAll(AMOUNT_OUTPUT_CONVERT_PATTERN, DELIMITER_COMMA));
        }
    }

    public void printTotalDiscountAmount(BenefitDetails benefitDetails) {
        System.out.printf(Message.TOTAL_DISCOUNT_AMOUNT.getMessage());
        if (benefitDetails.getTotalDiscountAmount() == MIN_AMOUNT) {
            System.out.printf(Message.CURRENCY_UNIT.getMessage(), MIN_AMOUNT);
            return;
        }
        System.out.printf(Message.MINUS_CURRENCY_UNIT.getMessage(),
                String.valueOf(benefitDetails.getTotalDiscountAmount())
                        .replaceAll(AMOUNT_OUTPUT_CONVERT_PATTERN, DELIMITER_COMMA));
    }

    public void printAmountOfPayment(int amount) {
        System.out.printf(Message.AMOUNT_OF_PAYMENT.getMessage());
        System.out.printf(Message.CURRENCY_UNIT.getMessage(), String.valueOf(amount)
                .replaceAll(AMOUNT_OUTPUT_CONVERT_PATTERN, DELIMITER_COMMA));
    }

    public void printEventBadge(BenefitDetails benefitDetails) {
        System.out.printf(Message.EVENT_BADGE.getMessage(), DECEMBER);
        System.out.println(benefitDetails.getBadge());
    }

    private enum Message {
        READ_DATE("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.%n" +
                "%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)%n"),
        READ_MENU("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
        EVENT_PREVIEW("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!%n"),
        ORDER_MENU("%n<주문 메뉴>%n"),
        TOTAL_AMOUNT("%n<할인 전 총주문 금액>%n"),
        GIVEAWAY("%n<증정 메뉴>%n"),
        BENEFIT_DETAILS("%n<혜택 내역>%n"),
        TOTAL_DISCOUNT_AMOUNT("%n<총혜택 금액>%n"),
        AMOUNT_OF_PAYMENT("%n<할인 후 예상 결제 금액>%n"),
        EVENT_BADGE("%n<%d월 이벤트 배지>%n"),
        NAME_AND_NUMBER("%s %d개%n"),
        CURRENCY_UNIT("%s원%n"),
        MINUS_CURRENCY_UNIT("-%s원%n"),
        NAME_AND_CURRENCY_UNIT("%s: -%s원%n"),
        NONE("없음");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
