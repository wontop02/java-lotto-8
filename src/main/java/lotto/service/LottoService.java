package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningLotto;

public class LottoService {
    public List<Lotto> issueLottos(PurchaseAmount purchaseAmount) {
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        return lottoMachine.issue();
    }

    public LottoResult calculateResult(List<Lotto> lottos, WinningLotto winningLotto) {
        return new LottoResult(lottos, winningLotto);
    }

    public double calculateProfitRate(LottoResult result, PurchaseAmount amount) {
        return result.calculateProfitRate(amount.getAmount());
    }
}
