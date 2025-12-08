package lotto.view;

import java.util.List;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";
    private static final String PRINT_LOTTO_SIZE = "\n%d개를 구매했습니다.";

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
        System.out.println();
    }

    public static void printLottos(List<String> lottos) {
        System.out.printf(PRINT_LOTTO_SIZE, lottos.size());
        System.out.println();
        lottos.forEach(System.out::println);
    }
}
