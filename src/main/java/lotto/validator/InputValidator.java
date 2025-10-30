package lotto.validator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import lotto.enums.ErrorMessage;

public class InputValidator {
    private static final String ONLY_DIGIT_REGEX = "^[0-9]+$";
    private static final String DIGITS_AND_COMMA_ONLY_REGEX = "^[0-9,]+$";

    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());
        }
    }

    private static void validateOnlyDigit(String input) {
        if (!input.matches(ONLY_DIGIT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ONLY_DIGIT.getMessage());
        }
    }

    private static void validateDigitsAndCommaOnly(String input) {
        if (!input.matches(DIGITS_AND_COMMA_ONLY_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIGITS_AND_COMMA_ONLY.getMessage());
        }
    }

    private static void validateWithinIntRange(String input, ErrorMessage errorMessage) {
        BigInteger value = new BigInteger(input);
        if (value.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0
                || value.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
            throw new IllegalArgumentException(errorMessage.getMessage());
        }
    }

    public static void validatePurchaseAmount(String input) {
        validateNotBlank(input);
        validateOnlyDigit(input);
        validateWithinIntRange(input, ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE);
    }

    public static void validateWinningNumbers(String input) {
        validateNotBlank(input);
        validateDigitsAndCommaOnly(input);
        List<String> numbers = Arrays.asList(input.split(",", -1));
        numbers.forEach(InputValidator::validateNotBlank);
        numbers.forEach(number -> validateWithinIntRange(number, ErrorMessage.INVALID_WINNING_NUMBER_RANGE));
    }

    public static void validateBonusNumber(String input) {
        validateNotBlank(input);
        validateOnlyDigit(input);
        validateWithinIntRange(input, ErrorMessage.INVALID_BONUS_NUMBER_RANGE);
    }
}
