package lotto.view;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    private OutputView() {
    }

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
        System.out.println();
    }
}
