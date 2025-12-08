package lotto.service;

import lotto.domain.PurchaseAmount;

public class LottoService {
    public PurchaseAmount createAmount(String input) {
        int amount = Integer.parseInt(input);
        return new PurchaseAmount(amount);
    }
}
