package lotto.util;

import static lotto.constant.LottoConstant.LOTTO_PRICE;
import static lotto.constant.LottoConstant.MAX_PURCHASE_AMOUNT;

import java.math.BigInteger;

public class InputValidator {
    private static final String NOT_ONLY_DIGIT = "숫자를 제외한 문자가 포함되어 있습니다.";
    private static final String ONLY_DIGIT_REGEX = "^[0-9]+$";

    private static final String NOT_DIGITS_AND_COMMA_ONLY = "숫자와 쉼표(,)를 제외한 문자가 포함되어 있습니다.";
    private static final String DIGITS_AND_COMMA_ONLY_REGEX = "^[0-9,]+$";

    private static final String INVALID_RANGE =
            String.format(
                    "%d 이상, %d 이하의 숫자여야 합니다.",
                    LOTTO_PRICE, MAX_PURCHASE_AMOUNT
            );


    private InputValidator() {
    }

    public static void validatePurchaseAmount(String input) {
        validateOnlyDigit(input);
        validateWithinIntRange(input);
    }

    private static void validateOnlyDigit(String input) {
        if (!input.matches(ONLY_DIGIT_REGEX)) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT);
        }
    }

    private static void validateWithinIntRange(String input) {
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    public static void validateWinLotto(String input) {
        validateDigitsAndCommaOnly(input);
    }

    private static void validateDigitsAndCommaOnly(String input) {
        if (!input.matches(DIGITS_AND_COMMA_ONLY_REGEX)) {
            throw new IllegalArgumentException(NOT_DIGITS_AND_COMMA_ONLY);
        }
    }
}
