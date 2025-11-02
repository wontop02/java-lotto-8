package lotto.controller;

import static lotto.constant.PrintMessageConstant.REQUEST_BONUS_NUMBER;
import static lotto.constant.PrintMessageConstant.REQUEST_PURCHASE_AMOUNT;
import static lotto.constant.PrintMessageConstant.REQUEST_WINNING_NUMBERS;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;
import lotto.service.LottoService;
import lotto.util.LottoConverter;
import lotto.validator.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void start() {
        PurchaseAmount purchaseAmount = inputPurchaseAmount();

        List<Lotto> lottos = lottoService.issueLottos(purchaseAmount);
        OutputView.printLottos(LottoConverter.toNumberLists(lottos));

        WinningLotto winningLotto = makeWinningLotto();

        LottoResult lottoResult = lottoService.calculateResult(lottos, winningLotto);

        double profitRate = lottoService.calculateProfitRate(lottoResult, purchaseAmount);
        OutputView.printResultMessage(lottoResult.getRankCount(), profitRate);
    }

    private PurchaseAmount inputPurchaseAmount() {
        while (true) {
            try {
                OutputView.printMessage(REQUEST_PURCHASE_AMOUNT);
                String input = InputView.readInput();
                InputValidator.validatePurchaseAmount(input);
                long amount = Long.parseLong(input);
                return new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto makeWinningLotto() {
        Lotto winningNumbers = inputWinningNumbers();
        while (true) {
            try {
                int bonusNumber = inputBonusNumber();
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private Lotto inputWinningNumbers() {
        while (true) {
            try {
                OutputView.printMessage(REQUEST_WINNING_NUMBERS);
                String input = InputView.readInput();
                InputValidator.validateWinningNumbers(input);
                List<Integer> numbers = LottoConverter.toNumbers(input);
                return new Lotto(numbers);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int inputBonusNumber() {
        while (true) {
            try {
                OutputView.printMessage(REQUEST_BONUS_NUMBER);
                String input = InputView.readInput();
                InputValidator.validateBonusNumber(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
