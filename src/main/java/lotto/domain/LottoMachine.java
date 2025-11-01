package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final int lottoCount;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoMachine(PurchaseAmount purchaseAmount,
                        LottoNumberGenerator lottoNumberGenerator) {
        this.lottoCount = purchaseAmount.getAmount() / LOTTO_PRICE;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> issue() {
        List<Lotto> lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(lottoNumberGenerator.generate());
            lottos.add(lotto);
        }
        return lottos;
    }
}
