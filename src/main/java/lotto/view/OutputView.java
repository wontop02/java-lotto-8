package lotto.view;

import static lotto.enums.LottoRank.NONE;
import static lotto.enums.LottoRank.SECOND;

import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PRINT_LOTTO_SIZE = "\n%d개를 구매했습니다.";
    private static final String PRINT_RESULT =
            "\n당첨 통계\n"
                    + "---";
    private static final String PRINT_LOTTO_PRIZE = "%d개 일치%s (%,d원) - %d개";
    private static final String SECOND_LOTTO_PRIZE = ", 보너스 볼 일치";
    private static final String PRINT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printLottos(List<String> lottos) {
        System.out.printf(PRINT_LOTTO_SIZE, lottos.size());
        System.out.println();
        lottos.forEach(System.out::println);
    }

    public static void printResult(Map<LottoRank, Integer> result) {
        System.out.println(PRINT_RESULT);
        for (LottoRank rank : LottoRank.values()) {
            if (rank == NONE) {
                continue;
            }
            int count = result.getOrDefault(rank, 0);
            if (rank == SECOND) {
                System.out.printf(PRINT_LOTTO_PRIZE, rank.getMatchCount(), SECOND_LOTTO_PRIZE, rank.getPrize(),
                        count);
                System.out.println();
                continue;
            }
            System.out.printf(PRINT_LOTTO_PRIZE, rank.getMatchCount(), "", rank.getPrize(),
                    count);
            System.out.println();
        }
    }

    public static void printRateOfReturn(double rate) {
        System.out.printf(PRINT_RATE_OF_RETURN, rate);
    }
}
