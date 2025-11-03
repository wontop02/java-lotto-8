package lotto.util;

import static lotto.constant.ErrorMessageConstant.BLANK_INPUT;
import static lotto.constant.ErrorMessageConstant.INVALID_NUMBER_RANGE;
import static lotto.constant.ErrorMessageConstant.INVALID_PURCHASE_AMOUNT_RANGE;
import static lotto.constant.ErrorMessageConstant.NOT_DIGITS_AND_COMMA_ONLY;
import static lotto.constant.ErrorMessageConstant.NOT_ONLY_DIGIT;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class InputValidator {
    private static final String ONLY_DIGIT_REGEX = "^[0-9]+$";
    private static final String DIGITS_AND_COMMA_ONLY_REGEX = "^[0-9,]+$";

    private InputValidator() {}

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT);
        }
    }

    private static void validateOnlyDigit(String input) {
        if (!input.matches(ONLY_DIGIT_REGEX)) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT);
        }
    }

    private static void validateDigitsAndCommaOnly(String input) {
        if (!input.matches(DIGITS_AND_COMMA_ONLY_REGEX)) {
            throw new IllegalArgumentException(NOT_DIGITS_AND_COMMA_ONLY);
        }
    }

    private static void validateWithinIntRange(String input, String errorMessage) {
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validatePurchaseAmount(String input) {
        validateNotBlank(input);
        validateOnlyDigit(input);
        validateWithinIntRange(input, INVALID_PURCHASE_AMOUNT_RANGE);
    }

    public static void validateWinningNumbers(String input) {
        validateNotBlank(input);
        validateDigitsAndCommaOnly(input);
        List<String> numbers = Arrays.asList(input.split(",", -1));
        numbers.forEach(InputValidator::validateNotBlank);
        numbers.forEach(number -> validateWithinIntRange(number, INVALID_NUMBER_RANGE));
    }

    public static void validateBonusNumber(String input) {
        validateNotBlank(input);
        validateOnlyDigit(input);
        validateWithinIntRange(input, INVALID_NUMBER_RANGE);
    }
}
