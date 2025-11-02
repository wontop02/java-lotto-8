package lotto.view;

import static lotto.constant.PrintMessageConstant.BONUS_MESSAGE;
import static lotto.constant.PrintMessageConstant.ERROR_PREFIX;
import static lotto.constant.PrintMessageConstant.ERROR_SUFFIX;
import static lotto.constant.PrintMessageConstant.PROFIT_FORMAT;
import static lotto.constant.PrintMessageConstant.PURCHASE_COUNT_MESSAGE;
import static lotto.constant.PrintMessageConstant.RESULT_FORMAT;
import static lotto.constant.PrintMessageConstant.RESULT_TITLE;

import java.util.List;
import java.util.Map;
import lotto.enums.Rank;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message + ERROR_SUFFIX);
    }

    public static void printLottos(List<List<Integer>> lottos) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, lottos.size());
        lottos.forEach(System.out::println);
    }

    public static void printResultMessage(Map<Rank, Integer> rankCount, double profitRate) {
        System.out.println(RESULT_TITLE);
        printRankCount(rankCount);
        printProfitRate(profitRate);
    }

    private static void printRankCount(Map<Rank, Integer> rankCount) {
        List<Rank> ranks = List.of(Rank.values()).reversed();
        for (Rank rank : ranks) {
            if (rank == Rank.NOTHING) continue;

            String bonusBallmessage = "";
            if (rank == Rank.SECOND_PLACE) {
                bonusBallmessage = BONUS_MESSAGE;
            }

            System.out.printf(RESULT_FORMAT,
                    rank.getMatchCount(), bonusBallmessage, rank.getPrizeMoney(),
                    rankCount.getOrDefault(rank, 0)
            );
        }
    }

    private static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_FORMAT, profitRate);
    }
}
