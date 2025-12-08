package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;

public class PurchaseAmount {
    private static final String INVALID_RANGE =
            String.format(
                    "%d 이상, %d 이하의 숫자여야 합니다.",
                    LOTTO_PRICE, MAX_PURCHASE_AMOUNT
            );

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < LOTTO_PRICE || amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }
}
