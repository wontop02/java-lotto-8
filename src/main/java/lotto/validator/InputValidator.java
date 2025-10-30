package lotto.validator;

import lotto.enums.ErrorMessage;

public class InputValidator {
    private static void validateNotBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT.getMessage());
        }
    }

    public static void validatePurchaseAmount(String input) {
        validateNotBlank(input);
    }

    public static void validateWinningNumbers(String input) {
        validateNotBlank(input);
    }

    public static void validateBonusNumber(String input) {
        validateNotBlank(input);
    }
}
