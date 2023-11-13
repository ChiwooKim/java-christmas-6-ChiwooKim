package christmas.domain;

import java.util.Map;

public class Bill {

    private static final int INITIAL_VALUE = 0;

    private int numberOfDessert;
    private int numberOfMain;
    private int totalAmount;

    public Bill() {
        this.numberOfDessert = INITIAL_VALUE;
        this.numberOfMain = INITIAL_VALUE;
        this.totalAmount = INITIAL_VALUE;
    }

    public static Bill getBill() {
        return new Bill();
    }

    public void calculate(Map<String, Integer> orderInfo) {
        int totalAmount = INITIAL_VALUE;
        for (String menu : orderInfo.keySet()) {
            this.totalAmount += getPrice(menu, orderInfo) * orderInfo.get(menu);
        }
    }

    private int getPrice(String menu, Map<String, Integer> orderInfo) {
        for (Menu type : Menu.values()) {
            if (type.getMenuName().contains(menu)) {
                int index = type.getMenuName().indexOf(menu);
                checkType(type, menu, orderInfo);
                return type.getMenuPrice().get(index);
            }
        }
        return INITIAL_VALUE;
    }

    private void checkType(Menu type, String menu, Map<String, Integer> orderInfo) {
        if (type == Menu.DESSERT) {
            this.numberOfDessert += orderInfo.get(menu);
        }
        if (type == Menu.MAIN) {
            this.numberOfMain += orderInfo.get(menu);
        }
    }

    public int getNumberOfDessert() {
        return numberOfDessert;
    }

    public int getNumberOfMain() {
        return numberOfMain;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
