package christmas.view;

import static christmas.util.Constant.*;

import camp.nextstep.edu.missionutils.Console;
import christmas.util.validator.DateValidator;
import christmas.util.validator.MenuValidator;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    public int readDate() {
        DateValidator validator = DateValidator.getValidator();
        while (true) {
            try {
                String inputDate = input();
                validator.validate(inputDate);
                return Integer.parseInt(inputDate);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    public Map<String, Integer> readMenu() {
        MenuValidator validator = MenuValidator.getValidator();
        while (true) {
            try {
                String inputOrder = input();
                validator.validate(inputOrder);
                return getOrder(inputOrder);
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
    }

    private Map<String, Integer> getOrder(String inputOrder) {
        Map<String, Integer> order = new HashMap<>();
        String[] menus = inputOrder.split(DELIMITER_COMMA);
        for (String menu : menus) {
            String[] menuInfo = menu.split(DELIMITER_HYPHEN);
            order.put(menuInfo[0], Integer.parseInt(menuInfo[1]));
        }
        return order;
    }

    private String input() {
        return Console.readLine();
    }
}
