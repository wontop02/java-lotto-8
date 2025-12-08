package lotto.service;

import static lotto.constant.LottoConstant.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumberParser;
import lotto.domain.Lotto;
import lotto.domain.LottoParser;
import lotto.domain.PurchaseAmount;
import lotto.util.LottoNumberGenerator;

public class LottoService {
    public PurchaseAmount createAmount(String input) {
        int amount = Integer.parseInt(input);
        return new PurchaseAmount(amount);
    }

    public List<Lotto> issueLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = amount / LOTTO_PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return lottos;
    }

    public Lotto createWinLotto(String input) {
        List<String> inputs = Arrays.asList(input.split(","));
        return LottoParser.toLotto(inputs);
    }

    public int createBonusNumber(String input, Lotto winLotto) {
        return BonusNumberParser.toBonusNumber(input, winLotto);
    }
}
