package lotto.util;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;

public class LottoConverter {
    private LottoConverter() {}

    public static List<List<Integer>> toNumberLists(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public static List<Integer> toNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
