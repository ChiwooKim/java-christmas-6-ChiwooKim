package christmas.util;

public enum ErrorMessage {

    INVALID_DATE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_TOTAL_NUMBER_OF_MENUS("메뉴는 한 번에 최대 20개 까지만 주문할 수 있습니다. 다시 입력해 주세요."),
    INVALID_ORDER("음료만 주문할 수 없습니다. 다시 입력해 주세요.");

    private static final String ERROR_MESSAGE = "[ERROR] %s";
    private final String message;

    ErrorMessage(String message) {
        this.message = String.format(ERROR_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
