package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
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
        List<Lotto> lottos = service.issueLottos(amount.getAmount());
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
