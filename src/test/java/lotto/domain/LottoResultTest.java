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
}
