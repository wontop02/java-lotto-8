package lotto.util;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoNumberGenerator {
    private LottoNumberGenerator() {}

    public static List<Integer> generate() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }
}
