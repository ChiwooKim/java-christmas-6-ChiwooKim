package christmas.domain;

import java.util.List;

public enum Menu {

    APPETIZER(List.of("양송이수프", "타파스", "시저샐러드"), List.of(6000, 5500, 8000)),
    MAIN(List.of("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스타"), List.of(55000, 54000, 35000, 25000)),
    DESSERT(List.of("초코케이크", "아이스크림"), List.of(15000, 5000)),
    BEVERAGE(List.of("제로콜라", "레드와인", "샴페인"), List.of(3000, 60000, 25000));

    private final List<String> menuName;
    private final List<Integer> menuPrice;

    Menu(List<String> menuName, List<Integer> menuPrice) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public List<String> getMenuName() {
        return menuName;
    }

    public List<Integer> getMenuPrice() {
        return menuPrice;
    }
}
