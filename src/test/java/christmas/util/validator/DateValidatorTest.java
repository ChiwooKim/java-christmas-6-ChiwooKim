package christmas.util.validator;


import static christmas.util.Constant.*;
import static christmas.util.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateValidatorTest {

    @ParameterizedTest
    @DisplayName("날짜 검증 - 입력 날짜가 숫자인지 확인")
    @ValueSource(strings = {"일", "one", "", "1 "})
    void validateNumber(String input) {
        DateValidator validator = DateValidator.getValidator();

        assertThatCode(() -> validator
                .validateNumber("0", NUMBER_PATTERN, INVALID_DATE.getMessage()))
                .doesNotThrowAnyException();
        assertThatThrownBy(() -> validator
                .validateNumber(input, NUMBER_PATTERN, INVALID_DATE.getMessage()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("날짜 검증 - 1 ~ 31일 사이의 날짜인지 확인")
    void validateNumberRange() {
        DateValidator validator = DateValidator.getValidator();

        assertThatCode(() -> validator
                .validateNumberRange(31, DATE_MINIMUM_RANGE, DATE_MAXIMUM_RANGE, INVALID_DATE.getMessage()))
                .doesNotThrowAnyException();
        assertThatThrownBy(() -> validator
                .validateNumberRange(0, DATE_MINIMUM_RANGE, DATE_MAXIMUM_RANGE, INVALID_DATE.getMessage()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        assertThatThrownBy(() -> validator
                .validateNumberRange(32, DATE_MINIMUM_RANGE, DATE_MAXIMUM_RANGE, INVALID_DATE.getMessage()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}