package christmas.util.validator;

import static christmas.util.ErrorMessage.*;

public class DateValidator extends Validator {

    public static final String DATE_PATTERN = "^\\d{1,2}$";
    public static final int DATE_MINIMUM_RANGE = 1;
    public static final int DATE_MAXIMUM_RANGE = 31;

    public static DateValidator getValidator() {
        return new DateValidator();
    }

    @Override
    public void validate(String input) {
        validateInputPattern(input, DATE_PATTERN, INVALID_DATE.getMessage());
        int date = Integer.parseInt(input);
        validateNumberRange(date, DATE_MINIMUM_RANGE, DATE_MAXIMUM_RANGE, INVALID_DATE.getMessage());
    }
}
