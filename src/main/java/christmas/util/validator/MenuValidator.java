package christmas.util.validator;

import static christmas.util.Constant.*;
import static christmas.util.ErrorMessage.*;

import christmas.domain.Menu;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuValidator extends Validator {

    public static MenuValidator getValidator() {
        return new MenuValidator();
    }

    public void validate(String input) {
        List<String> menus = Arrays.asList(input.split(DELIMITER_COMMA));
        Set<String> checkMenus = new HashSet<>();
        int numberOfBeverages = 0;
        int totalNumber = 0;
        validateIterator(menus, checkMenus, numberOfBeverages, totalNumber);
    }

    private void validateIterator(List<String> menus, Set<String> checkMenus, int numberOfBeverages, int totalNumber) {
        for (String menu : menus) {
            validateInputPattern(menu, MENU_INPUT_FORMAT_PATTERN, INVALID_MENU.getMessage());
            String[] menuInfo = menu.split(DELIMITER_HYPHEN);

            String menuName = menuInfo[0];
            numberOfBeverages = getNumberOfBeverages(checkMenus, numberOfBeverages, menuName);

            int numberOfMenus = Integer.parseInt(menuInfo[1]);
            totalNumber = getTotalNumber(totalNumber, numberOfMenus);
        }
        validateDuplication(menus, checkMenus);
        validateOnlyBeverage(menus, numberOfBeverages);
        validateTotalNumber(totalNumber);
    }

    private int getTotalNumber(int totalNumber, int numberOfMenus) {
        validateNumberRange(numberOfMenus, MENU_MINIMUM_RANGE, MENU_MAXIMUM_RANGE, INVALID_MENU.getMessage());
        totalNumber += numberOfMenus;
        return totalNumber;
    }

    private int getNumberOfBeverages(Set<String> checkMenus, int numberOfBeverages, String menuName) {
        validateNoMenu(menuName);
        checkMenus.add(menuName);
        if (Menu.BEVERAGE.getMenuName().contains(menuName)) {
            numberOfBeverages++;
        }
        return numberOfBeverages;
    }

    private void validateOnlyBeverage(List<String> menus, int numberOfBeverages) {
        if (menus.size() == numberOfBeverages) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private void validateTotalNumber(int totalNumber) {
        if (totalNumber > TOTAL_NUMBER_OF_MENUS) {
            throw new IllegalArgumentException(INVALID_TOTAL_NUMBER_OF_MENUS.getMessage());
        }
    }

    private void validateDuplication(List<String> menus, Set<String> duplication) {
        if (menus.size() != duplication.size()) {
            throw new IllegalArgumentException(INVALID_MENU.getMessage());
        }
    }

    private void validateNoMenu(String menu) {
        boolean exist = false;
        for (Menu type : Menu.values()) {
            if (type.getMenuName().contains(menu)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new IllegalArgumentException(INVALID_MENU.getMessage());
        }
    }
}
