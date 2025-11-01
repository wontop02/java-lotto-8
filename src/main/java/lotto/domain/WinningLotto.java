package lotto.domain;

import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;
import static lotto.enums.ErrorMessage.DUPLICATED_WINNING_AND_BONUS_NUMBER;
import static lotto.enums.ErrorMessage.INVALID_NUMBER_RANGE;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
        if (winningLotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(
                    DUPLICATED_WINNING_AND_BONUS_NUMBER.getMessage()
            );
        }
    }
}
