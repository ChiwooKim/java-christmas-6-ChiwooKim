package christmas.util;

public class Constant {

    public static final int DATE_MINIMUM_RANGE = 1;
    public static final int DATE_MAXIMUM_RANGE = 31;
    public static final int MENU_MINIMUM_RANGE = 1;
    public static final int MENU_MAXIMUM_RANGE = 20;
    public static final int TOTAL_NUMBER_OF_MENUS = 20;
    public static final int DECEMBER = 12;

    public static final String DELIMITER_COMMA = ",";
    public static final String DELIMITER_HYPHEN = "-";
    public static final String NUMBER_PATTERN = "^\\d{1,2}$";
    public static final String MENU_INPUT_FORMAT_PATTERN = "\\S{1,}-\\d{1,2}";
    public static final String AMOUNT_OUTPUT_CONVERT_PATTERN = "\\B(?=(\\d{3})+(?!\\d))";
}
