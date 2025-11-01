package lotto.enums;

public enum Rank {
    FIRST_PLACE(2_000_000_000),
    SECOND_PLACE(30_000_000),
    THIRD_PLACE(1_500_000),
    FOURTH_PLACE(50_000),
    FIFTH_PLACE(5_000),
    NOTHING(0);

    private final long prizeMoney;

    Rank(long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank valueOf(long matchCount, boolean isBonusMatched) {
        if (matchCount == 6) return FIRST_PLACE;
        if (matchCount == 5 && isBonusMatched) return SECOND_PLACE;
        if (matchCount == 5) return THIRD_PLACE;
        if (matchCount == 4) return FOURTH_PLACE;
        if (matchCount == 3) return FIFTH_PLACE;
        return NOTHING;
    }
}
