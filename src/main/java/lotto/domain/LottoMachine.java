package lotto.domain;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;
import lotto.util.LottoNumberGenerator;

public class LottoMachine {
    private final int lottoCount;

    public LottoMachine(PurchaseAmount purchaseAmount) {
        this.lottoCount = (int)(purchaseAmount.getAmount() / LOTTO_PRICE);
    }

    public List<Lotto> issue() {
        List<Lotto> lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generate());
            lottos.add(lotto);
        }
        return List.copyOf(lottos);
    }
}
