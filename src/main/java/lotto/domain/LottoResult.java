package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.Rank;

public class LottoResult {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;
    private final Map<Rank, Integer> rankCount;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = List.copyOf(lottos);
        this.winningLotto = winningLotto;
        this.rankCount = calculateRankCount();
    }

    public long calculateTotalPrize() {
        return rankCount.entrySet().stream()
                .mapToLong(entry ->
                        entry.getKey().getPrizeMoney() * entry.getValue())
                .sum();
    }

    public double calculateProfitRate(long purchaseAmount) {
        long totalPrize = calculateTotalPrize();
        double profitRate = (double)totalPrize / (double)purchaseAmount * 100;
        return Math.round(profitRate * 10) / 10.0;
    }

    public Map<Rank, Integer> getRankCount() {
        return Map.copyOf(rankCount);
    }

    private Map<Rank, Integer> calculateRankCount() {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }
}
