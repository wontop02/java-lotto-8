package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.Rank;

public class LottoResult {
    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = List.copyOf(lottos);
        this.winningLotto = winningLotto;
    }

    public Map<Rank, Integer> rankLottos() {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.match(lotto);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }
}
