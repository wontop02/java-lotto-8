package lotto.domain;

import java.util.List;

public class LottoParser {
    private LottoParser() {
    }

    public static List<String> toStringList(List<Lotto> lottos) {
        return lottos.stream()
                .map(Lotto::toString)
                .toList();
    }
}
