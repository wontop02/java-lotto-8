package lotto.domain;

import static lotto.enums.ErrorMessage.DUPLICATED_WINNING_AND_BONUS_NUMBER;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;
        assertThatThrownBy(() -> new WinningLotto(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_WINNING_AND_BONUS_NUMBER.getMessage());
    }
}
