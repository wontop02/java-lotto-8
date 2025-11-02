package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    private final List<Lotto> lottos = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)),
            new Lotto(List.of(7, 8, 9, 10, 11, 12))
    );
    private final WinningLotto winningLotto = new WinningLotto(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)), 45
    );
    private final LottoResult lottoResult = new LottoResult(lottos, winningLotto);

    @DisplayName("모든 로또의 당첨 결과를 판단한다.")
    @Test
    void 모든_로또의_당첨_결과를_판단한다() {
        Map<Rank, Integer> rankCount = lottoResult.getRankCount();

        assertThat(rankCount.get(Rank.FIRST_PLACE)).isEqualTo(1);
        assertThat(rankCount.get(Rank.NOTHING)).isEqualTo(1);
    }

    @DisplayName("모든 로또의 총 당첨 금액을 계산한다.")
    @Test
    void 모든_로또의_총_당첨_금액을_계산한다() {
        long totalPrize = lottoResult.calculateTotalPrize();
        assertEquals(2_000_000_000L, totalPrize);
    }

    @DisplayName("수익률을 둘째 자리에서 반올림해 계산한다.")
    @Test
    void 수익률을_둘째_자리에서_반올림해_계산한다() {
        double profitRate = lottoResult.calculateProfitRate(2000L);
        assertEquals(100_000_000.0, profitRate);
    }
}
