package lotto.domain;

import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import java.math.BigInteger;

public class BonusNumberParser {
    private static final String INVALID_NUMBER_RANGE =
            String.format(
                    "보너스 번호는 %d에서 %d 사이어야 합니다.",
                    MIN_NUMBER, MAX_NUMBER
            );
    private static final String CAN_NOT_DUPLICATED_WIN_LOTTO = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private BonusNumberParser() {
    }

    public static int toBonusNumber(String input, Lotto winLotto) {
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
        int bonus = Integer.parseInt(input);
        if (winLotto.numbers().contains(bonus)) {
            throw new IllegalArgumentException(CAN_NOT_DUPLICATED_WIN_LOTTO);
        }
        return bonus;
    }
}
