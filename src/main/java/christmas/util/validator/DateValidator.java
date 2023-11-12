package christmas.util.validator;

import static christmas.util.Constant.*;
import static christmas.util.ErrorMessage.*;

public class DateValidator extends Validator {

    public static DateValidator getValidator() {
        return new DateValidator();
    }

    public void validate(String input) {
        validateInputPattern(input, NUMBER_PATTERN, INVALID_DATE.getMessage());
        int date = Integer.parseInt(input);
        validateNumberRange(date, DATE_MINIMUM_RANGE, DATE_MAXIMUM_RANGE, INVALID_DATE.getMessage());
    }
}
