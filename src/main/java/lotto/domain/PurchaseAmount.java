package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;

public class PurchaseAmount {
    private static final String INVALID_RANGE =
            String.format(
                    "구입 금액은 %,d원 이상, %,d원 이하여야 합니다.",
                    LOTTO_PRICE, MAX_PURCHASE_AMOUNT
            );
    private static final String INVALID_UNIT =
            String.format(
                    "구입 금액은 %,d원 단위여야 합니다.",
                    LOTTO_PRICE
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
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_UNIT);
        }
    }

    public int getAmount() {
        return amount;
    }
}
