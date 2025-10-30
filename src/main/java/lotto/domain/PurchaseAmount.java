package lotto.domain;

import lotto.enums.ErrorMessage;

public class PurchaseAmount {
    private final int purchaseAmount;

    public PurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        validate(amount);
        this.purchaseAmount = amount;
    }

    private void validate(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException(
                    ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE.getMessage()
            );
        }
    }
}
