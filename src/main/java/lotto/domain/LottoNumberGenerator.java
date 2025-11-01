package lotto.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.List;

public class LottoNumberGenerator {
    public List<Integer> generate() {
        return pickUniqueNumbersInRange(1, 45, 6);
    }
}
