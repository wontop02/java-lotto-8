package lotto.enums;

public enum Rank {
    FIRST_PLACE(6, 2_000_000_000L),
    SECOND_PLACE(5, 30_000_000L),
    THIRD_PLACE(5, 1_500_000L),
    FOURTH_PLACE(4, 50_000L),
    FIFTH_PLACE(3, 5_000L),
    NOTHING(0, 0L);

    private final long matchCount;
    private final long prizeMoney;

    Rank(long matchCount, long prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public long getMatchCount() {
        return matchCount;
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
