package lotto.domain;

import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import java.math.BigInteger;
import java.util.List;

public class LottoParser {
    private static final String INVALID_NUMBER_RANGE =
            String.format(
                    "로또 번호는 %d에서 %d 사이어야 합니다.",
                    MIN_NUMBER, MAX_NUMBER
            );

    private LottoParser() {
    }

    public static List<String> toStringList(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::toString)
                .toList();
    }

    public static Lotto toLotto(List<String> inputs) {
        for (String input : inputs) {
            if (input.isBlank()) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
            }
            BigInteger value = new BigInteger(input);
            if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                    || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
            }
        }
        List<Integer> numbers = inputs.stream()
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }
}
