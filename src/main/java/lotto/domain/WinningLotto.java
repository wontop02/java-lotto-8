package lotto.domain;

import static lotto.constant.ErrorMessageConstant.DUPLICATED_WINNING_AND_BONUS_NUMBER;
import static lotto.constant.ErrorMessageConstant.INVALID_NUMBER_RANGE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import lotto.enums.Rank;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningNumbers = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        long matchCount = lotto.getNumbers().stream()
                .filter(number -> winningNumbers.getNumbers().contains(number))
                .count();
        boolean isBonusMatched = (matchCount == 5)
                && lotto.getNumbers().contains(bonusNumber);
        return Rank.valueOf(matchCount, isBonusMatched);
    }

    private void validateBonusNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
        if (winningNumbers.getNumbers().contains(number)) {
            throw new IllegalArgumentException(DUPLICATED_WINNING_AND_BONUS_NUMBER);
        }
    }
}
