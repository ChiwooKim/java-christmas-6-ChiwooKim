package christmas.domain;

import java.util.Map;

public class Bill {

    public static Bill getBill() {
        return new Bill();
    }

    public int calculate(Map<String, Integer> orderInfo) {
        int totalAmount = 0;
        for (String menu : orderInfo.keySet()) {
            totalAmount += getPrice(menu) * orderInfo.get(menu);
        }
        return totalAmount;
    }

    private int getPrice(String menu) {
        for (Menu type : Menu.values()) {
            if (type.getMenuName().contains(menu)) {
                int index = type.getMenuName().indexOf(menu);
                return type.getMenuPrice().get(index);
            }
        }
        return 0;
    }
}
