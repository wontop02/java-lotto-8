package lotto.enums;

import static lotto.constant.LottoConstant.LOTTO_NUMBER_SIZE;
import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;
import static lotto.constant.LottoConstant.MIN_NUMBER;
import static lotto.constant.LottoConstant.MIN_PURCHASE_AMOUNT;

public enum ErrorMessage {
    BLANK_INPUT("빈 문자열이 입력되었습니다."),
    NOT_ONLY_DIGIT("숫자를 제외한 문자가 포함되어 있습니다."),
    NOT_DIGITS_AND_COMMA_ONLY("숫자와 쉼표(,)를 제외한 문자가 포함되어 있습니다."),

    INVALID_PURCHASE_AMOUNT_RANGE(
            String.format(
                    "구입 금액은 %,d원 이상, %,d원 이하의 숫자여야 합니다.",
                    MIN_PURCHASE_AMOUNT, MAX_PURCHASE_AMOUNT
            )
    ),
    INVALID_PURCHASE_AMOUNT_UNIT(
            String.format(
                    "구입 금액은 %,d원 단위로 입력해야 합니다.",
                    LOTTO_PRICE
            )
    ),

    INVALID_LOTTO_NUMBER_SIZE(
            String.format(
                    "로또 번호는 %d개여야 합니다.",
                    LOTTO_NUMBER_SIZE
            )
    ),
    INVALID_NUMBER_RANGE(
            String.format(
                    "로또 번호는 %d 이상 %d 이하의 숫자여야 합니다.",
                    MIN_NUMBER, MAX_NUMBER
            )
    ),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
