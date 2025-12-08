package lotto.service;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.enums.LottoRank.NONE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumberParser;
import lotto.domain.Lotto;
import lotto.domain.LottoParser;
import lotto.domain.PurchaseAmount;
import lotto.enums.LottoRank;
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

    public Map<LottoRank, Integer> calculateResult(List<Lotto> lottos, Lotto winLotto, int bonus) {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottos) {
            List<Integer> match = new ArrayList<>(lotto.numbers());
            match.retainAll(winLotto.numbers());
            boolean matchBonus = lotto.numbers().contains(bonus);
            LottoRank rank = LottoRank.getLottoRank(match.size(), matchBonus);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    public double calculateRateOfReturn(Map<LottoRank, Integer> result, PurchaseAmount amount) {
        long totalPrize = 0;
        for (Map.Entry<LottoRank, Integer> entry : result.entrySet()) {
            if (entry.getKey() == NONE) {
                continue;
            }
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }
        return totalPrize / (double) amount.getAmount() * 100;
    }
}
