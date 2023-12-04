package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.validator.DateValidator;

public class InputView {

    public int readDate() {
        DateValidator validator = new DateValidator();
        while (true) {
            try {
                System.out.printf(ViewMessage.READ_DATE.getMessage());
                String date = input();
                validator.validate(date);
                return Integer.parseInt(date);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String input() {
        return Console.readLine();
    }
}
