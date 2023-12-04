package christmas.domain.event;

public enum badge {
    SANTA(20_000, "산타"),
    TREE(10_000, "트리"),
    STAR(5_000, "별"),
    NONE(0, "없음");

    private final int account;
    private final String badgeName;

    badge(int account, String badgeName) {
        this.account = account;
        this.badgeName = badgeName;
    }

    public int getAccount() {
        return account;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
