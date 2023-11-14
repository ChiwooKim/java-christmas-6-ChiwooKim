package christmas.util.validator;

import static christmas.util.Constant.*;
import static christmas.util.ErrorMessage.*;

import christmas.domain.Menu;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuValidator extends Validator {

    public static final String MENU_INPUT_FORMAT_PATTERN = "\\S{1,}-\\d{1,2}";
    public static final int MENU_MINIMUM_RANGE = 1;
    public static final int MENU_MAXIMUM_RANGE = 20;
    public static final int TOTAL_NUMBER_OF_MENUS = 20;
    private final Set<String> checkMenus;
    private int numberOfBeverages;
    private int totalNumber;

    public MenuValidator() {
        this.checkMenus = new HashSet<>();
        this.numberOfBeverages = 0;
        this.totalNumber = 0;
    }

    public static MenuValidator getValidator() {
        return new MenuValidator();
    }

    public void validate(String input) {
        List<String> menus = Arrays.asList(input.split(DELIMITER_COMMA));
        validateIterator(menus);
        validateDuplication(menus);
        validateOnlyBeverage(menus);
        validateTotalNumber();
    }

    private void validateIterator(List<String> menus) {
        for (String menu : menus) {
            validateInputPattern(menu, MENU_INPUT_FORMAT_PATTERN, INVALID_MENU.getMessage());
            String[] menuInfo = menu.split(DELIMITER_HYPHEN);
            getNumberOfBeverages(menuInfo[0]);
            getTotalNumber(Integer.parseInt(menuInfo[1]));
        }
    }

    private void getTotalNumber(int numberOfMenus) {
        validateNumberRange(numberOfMenus, MENU_MINIMUM_RANGE, MENU_MAXIMUM_RANGE, INVALID_MENU.getMessage());
        totalNumber += numberOfMenus;
    }

    private void getNumberOfBeverages(String menuName) {
        validateNoMenu(menuName);
        checkMenus.add(menuName);
        if (Menu.BEVERAGE.getMenuName().contains(menuName)) {
            numberOfBeverages++;
        }
    }

    private void validateOnlyBeverage(List<String> menus) {
        if (menus.size() == numberOfBeverages) {
            throw new IllegalArgumentException(INVALID_ORDER.getMessage());
        }
    }

    private void validateTotalNumber() {
        if (totalNumber > TOTAL_NUMBER_OF_MENUS) {
            throw new IllegalArgumentException(INVALID_TOTAL_NUMBER_OF_MENUS.getMessage());
        }
    }

    private void validateDuplication(List<String> menus) {
        if (menus.size() != checkMenus.size()) {
            throw new IllegalArgumentException(INVALID_MENU.getMessage());
        }
    }

    private void validateNoMenu(String menu) {
        boolean existMenu = Menu.isExistMenu(menu);
        if (!existMenu) {
            throw new IllegalArgumentException(INVALID_MENU.getMessage());
        }
    }
}
