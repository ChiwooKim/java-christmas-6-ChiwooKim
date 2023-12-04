package christmas.view;

public enum ViewMessage {
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

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
