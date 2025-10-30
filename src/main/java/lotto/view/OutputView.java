package lotto.view;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message + " 다시 입력해 주세요.");
    }
}
