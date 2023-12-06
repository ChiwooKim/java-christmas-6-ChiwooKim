package christmas.domain.event;

import java.util.Arrays;

public enum Badge {
    SANTA(20_000, "산타"),
    TREE(10_000, "트리"),
    STAR(5_000, "별"),
    NONE(0, "없음");

    private final int amount;
    private final String badgeName;

    Badge(int amount, String badgeName) {
        this.amount = amount;
        this.badgeName = badgeName;
    }

    public int getAmount() {
        return amount;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public static String getBadge(int benefitsAmount) {
        return Arrays.stream(Badge.values())
                .filter(badge -> badge.getAmount() <= benefitsAmount)
                .findAny()
                .get()
                .getBadgeName();
    }
}
