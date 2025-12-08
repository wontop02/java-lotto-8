package lotto.controller;

import lotto.domain.PurchaseAmount;
import lotto.service.LottoService;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService service;

    public LottoController(LottoService service) {
        this.service = service;
    }

    public void run() {
        PurchaseAmount amount = requestPurchaseAmount();
    }

    public PurchaseAmount requestPurchaseAmount() {
        while (true) {
            try {
                String input = InputView.requestPurchaseAmount();
                InputValidator.validatePurchaseAmount(input);
                return service.createAmount(input);
            } catch (Exception e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
