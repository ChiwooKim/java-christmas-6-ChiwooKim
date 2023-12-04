package christmas.view;

import static christmas.exception.EventException.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String DELIMITER = ",";
    private static final Pattern DATE_PATTERN = Pattern.compile("^[0-9]{1,2}$");
    private static final Pattern MENU_PATTERN = Pattern.compile("[0-9a-zA-Z가-힣]+-[0-9]{1,2}");

    public int readDate() {
        String date = input();
        if (!DATE_PATTERN.matcher(date).matches()) {
            throw INVALID_DATE.makeException();
        }
        return Integer.parseInt(date);
    }

    public List<String> readMenus() {
        return Arrays
                .stream(input().split(DELIMITER))
                .peek(menu -> {
                    if (!MENU_PATTERN.matcher(menu).matches()) {
                        throw INVALID_MENU.makeException();
                    }
                })
                .collect(Collectors.toList());
    }

    private String input() {
        return Console.readLine();
    }
}
