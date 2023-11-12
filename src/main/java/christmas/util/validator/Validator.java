package christmas.util.validator;

import java.util.regex.Pattern;

public abstract class Validator {

    public void validateNumber(String input, String regex, String error) {
        Pattern pattern = Pattern.compile(regex);
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(error);
        }
    }

    public void validateNumberRange(int number, int minNumber, int maxNumber, String error) {
        if (number < minNumber || number > maxNumber) {
            throw new IllegalArgumentException(error);
        }
    }
}
