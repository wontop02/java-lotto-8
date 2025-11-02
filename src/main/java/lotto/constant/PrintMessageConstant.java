package lotto.constant;

public final class PrintMessageConstant {
    public static final String REQUEST_PURCHASE_AMOUNT = "\n구입금액을 입력해 주세요.";
    public static final String REQUEST_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_SUFFIX = " 다시 입력해 주세요.";

    public static final String PURCHASE_COUNT_MESSAGE = "\n%d개를 구매했습니다.\n";

    public static final String RESULT_TITLE = "\n당첨 통계\n---";
    public static final String RESULT_FORMAT = "%d개 일치%s (%,d원) - %d개\n";
    public static final String BONUS_MESSAGE = ", 보너스 볼 일치";
    public static final String PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.\n";
}
