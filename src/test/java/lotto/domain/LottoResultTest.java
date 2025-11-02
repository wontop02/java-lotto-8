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
            new Lotto(List.of(8, 21, 23, 41, 42, 43)),
            new Lotto(List.of(3, 5, 11, 16, 32, 38)),
            new Lotto(List.of(7, 11, 16, 35, 36, 44)),
            new Lotto(List.of(1, 8, 11, 31, 41, 42)),
            new Lotto(List.of(13, 14, 16, 38, 42, 45)),
            new Lotto(List.of(7, 11, 30, 40, 42, 43)),
            new Lotto(List.of(2, 13, 22, 32, 38, 45)),
            new Lotto(List.of(1, 3, 5, 14, 22, 45))
    );
    private final WinningLotto winningLotto = new WinningLotto(
            new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
    );
    private final LottoResult lottoResult = new LottoResult(lottos, winningLotto);

    @DisplayName("모든 로또의 당첨 결과를 판단한다.")
    @Test
    void 모든_로또의_당첨_결과를_판단한다() {
        Map<Rank, Integer> rankCount = lottoResult.getRankCount();

        assertThat(rankCount.get(Rank.FIFTH_PLACE)).isEqualTo(1);
    }

    @DisplayName("수익률을 둘째 자리에서 반올림해 계산한다.")
    @Test
    void 수익률을_둘째_자리에서_반올림해_계산한다() {
        double profitRate = lottoResult.calculateProfitRate(8000L);
        assertEquals(62.5, profitRate);
    }
}
