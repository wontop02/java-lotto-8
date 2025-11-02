package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import java.util.Map;
import lotto.enums.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @DisplayName("모든 로또의 당첨 결과를 판단한다")
    @Test
    void 모든_로또의_당첨_결과를_판단한다() {
        Lotto firstLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto nothingLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));
        List<Lotto> lottos = List.of(firstLotto, nothingLotto);
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(winningNumbers, 45);

        LottoResult lottoResult = new LottoResult(lottos, winningLotto);
        Map<Rank, Integer> rankCount = lottoResult.getRankCount();

        assertThat(rankCount.get(Rank.FIRST_PLACE)).isEqualTo(1);
        assertThat(rankCount.get(Rank.NOTHING)).isEqualTo(1);
    }
}
