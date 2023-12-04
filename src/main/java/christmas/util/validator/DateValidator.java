package christmas.util.validator;

import christmas.util.exception.EventException;
import java.util.regex.Pattern;

public class DateValidator {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 31;

    public void validate(String input) {
        validatePattern(input);
        validateNumberRange(input);
    }

    private void validatePattern(String input) {
        Pattern pattern = Pattern.compile("^\\d{1,2}$");
        if (!pattern.matcher(input).matches()) {
            throw EventException.INVALID_DATE.makeException();
        }
    }

    private void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_RANGE || MAX_RANGE < number) {
            throw EventException.INVALID_DATE.makeException();
        }
    }
}
