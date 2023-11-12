package christmas.util.validator;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MenuValidatorTest {

    MenuValidator validator;

    @BeforeEach
    void beforeEach() {
        this.validator = MenuValidator.getValidator();
    }

    @ParameterizedTest
    @DisplayName("메뉴 입력 형식 확인")
    @ValueSource(strings = {"", "-2", "해산물파스타-", "해산물파스타2",
            "해산물파스타-둘", "2-해산물파스타", "해산물 파스타-2"})
    void validateInputPattern(String input) {
        assertThatCode(() -> validator.validate("해산물파스타-2")).doesNotThrowAnyException();
        assertThatThrownBy(() -> validator
                .validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("없는 메뉴인지 확인")
    void validateMenu() {
        assertThatCode(() -> validator.validate("초코케이크-2")).doesNotThrowAnyException();
        assertThatThrownBy(() -> validator
                .validate("생크림케이크-2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("메뉴 주문 개수 확인")
    void validateNumber() {
        assertThatCode(() -> validator.validate("초코케이크-2")).doesNotThrowAnyException();
        assertThatThrownBy(() -> validator
                .validate("초코케이크-22"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("중복메뉴 주문인지 확인")
    void validateDuplication() {
        assertThatCode(() -> validator.validate("해산물파스타-2,레드와인-1,초코케이크-1"))
                .doesNotThrowAnyException();
        assertThatThrownBy(() -> validator
                .validate("시저샐러드-1,시저샐러드-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("음료만 주문했는지 확인")
    void validateOnlyBeverage() {
        assertThatCode(() -> validator.validate("해산물파스타-2,레드와인-1,초코케이크-1"))
                .doesNotThrowAnyException();
        assertThatThrownBy(() -> validator
                .validate("제로콜라-2,레드와인-1,샴페인-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("주문한 메뉴개수가 20개 보다 많은지 확인")
    void validateTotalNumber() {
        assertThatCode(() -> validator.validate("해산물파스타-2,레드와인-1,초코케이크-1"))
                .doesNotThrowAnyException();
        assertThatThrownBy(() -> validator
                .validate("해산물파스타-12,레드와인-11,초코케이크-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        "[ERROR] 메뉴는 한 번에 최대 20개 까지만 주문할 수 있습니다. 다시 입력해 주세요.");
    }
}