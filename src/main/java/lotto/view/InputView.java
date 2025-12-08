package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WIN_LOTTO = "\n당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String requestWinLotto() {
        System.out.println(REQUEST_WIN_LOTTO);
        return Console.readLine();
    }

    public static String requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER);
        return Console.readLine();
    }
}
