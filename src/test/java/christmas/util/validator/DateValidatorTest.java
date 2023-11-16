package christmas.util.validator;


import static christmas.util.Constant.*;
import static christmas.util.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateValidatorTest {

    private DateValidator validator;

    @BeforeEach
    void beforeEach() {
        this.validator = DateValidator.getValidator();
    }

    @ParameterizedTest
    @DisplayName("날짜 검증 - 입력 날짜가 숫자인지 확인")
    @ValueSource(strings = {"일", "one", "", "1 "})
    void validateNumber(String input) {
        assertThatCode(() -> validator.validate("1")).doesNotThrowAnyException();
        assertThatThrownBy(() -> validator.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("날짜 검증 - 1 ~ 31일 사이의 날짜인지 확인")
    void validateNumberRange() {
        assertThatCode(() -> validator.validate("31")).doesNotThrowAnyException();
        assertThatThrownBy(() -> validator.validate("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        assertThatThrownBy(() -> validator.validate("32"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}