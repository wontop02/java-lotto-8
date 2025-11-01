package lotto.domain;

import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;
import static lotto.constant.LottoConstant.MIN_PURCHASE_AMOUNT;
import static lotto.enums.ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE;
import static lotto.enums.ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT;

import lotto.constant.LottoConstant;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        validate(amount);
        this.purchaseAmount = amount;
    }

    private void validate(int amount) {
        if (amount < MIN_PURCHASE_AMOUNT || amount > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(
                    INVALID_PURCHASE_AMOUNT_RANGE.getMessage()
            );
        }
        if (amount % LottoConstant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(
                    INVALID_PURCHASE_AMOUNT_UNIT.getMessage()
            );
        }
    }
}
