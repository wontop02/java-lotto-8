package lotto.validator;

import static lotto.constant.ErrorMessageConstant.BLANK_INPUT;
import static lotto.constant.ErrorMessageConstant.NOT_DIGITS_AND_COMMA_ONLY;
import static lotto.constant.ErrorMessageConstant.NOT_ONLY_DIGIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidatorTest {
    private static Stream<Runnable> validatorsForBlankInput() {
        return Stream.of(
                () -> InputValidator.validatePurchaseAmount(" "),
                () -> InputValidator.validateWinningNumbers(" "),
                () -> InputValidator.validateBonusNumber(" ")
        );
    }

    private static Stream<Runnable> validatorsForNotOnlyDigit() {
        return Stream.of(
                () -> InputValidator.validatePurchaseAmount("-100"),
                () -> InputValidator.validateBonusNumber("5.2")
        );
    }

    private static Stream<Runnable> validatorsForExceedingIntRange() {
        return Stream.of(
                () -> InputValidator.validatePurchaseAmount("9999999999"),
                () -> InputValidator.validateWinningNumbers("1,2,3,4,5,9999999999"),
                () -> InputValidator.validateBonusNumber("9999999999")
        );
    }

    @DisplayName("입력값이 비어 있으면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("validatorsForBlankInput")
    void 입력값이_비어_있으면_예외가_발생한다(Runnable validatorCall) {
        assertThatThrownBy(validatorCall::run)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_INPUT);
    }

    @DisplayName("숫자를 제외한 문자가 존재하면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("validatorsForNotOnlyDigit")
    void 숫자를_제외한_문자가_존재하면_예외가_발생한다(Runnable validatorCall) {
        assertThatThrownBy(validatorCall::run)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ONLY_DIGIT);
    }

    @DisplayName("숫자와 쉼표를 제외한 문자가 존재하면 예외가 발생한다.")
    @Test
    void 숫자와_쉼표를_제외한_문자가_존재하면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1, 2, 3, 4, 5, 6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_DIGITS_AND_COMMA_ONLY);
    }

    @DisplayName("입력된 숫자가 int 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("validatorsForExceedingIntRange")
    void 입력된_숫자가_int_범위를_벗어나면_예외가_발생한다(Runnable validatorCall) {
        assertThatThrownBy(validatorCall::run)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
