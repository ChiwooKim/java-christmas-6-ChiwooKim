package christmas.exception;

public enum EventException {
    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_TOTAL_NUMBER_OF_MENUS("주문 메뉴 개수를 초과 했습니다. 총 20개 이하로 입력해 주세요."),
    INVALID_ORDER("음료만 주문할 수 없습니다. 다시 입력해 주세요."),
    ;

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private final String message;

    EventException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_MESSAGE + message;
    }

    public IllegalArgumentException makeException() {
        return new IllegalArgumentException(this.getMessage());
    }
}
