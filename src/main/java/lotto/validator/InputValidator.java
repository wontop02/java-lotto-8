package lotto.validator;

import lotto.enums.ErrorMessage;

public class InputValidator {
    private static final String ONLY_DIGIT_REGEX = "^[0-9]+$";
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

    public static void validatePurchaseAmount(String input) {
        validateNotBlank(input);
        validateOnlyDigit(input);
    }

    public static void validateWinningNumbers(String input) {
        validateNotBlank(input);
    }

    public static void validateBonusNumber(String input) {
        validateNotBlank(input);
        validateOnlyDigit(input);
    }
}
