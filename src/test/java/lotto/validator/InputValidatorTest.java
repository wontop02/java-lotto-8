package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class InputValidatorTest {
    private static final String BLANK_INPUT =
            "[ERROR] 빈 문자열이 입력되었습니다. 다시 입력해 주세요.";
    private static final String NOT_ONLY_DIGIT =
            "[ERROR] 숫자를 제외한 문자가 포함되어 있습니다. 다시 입력해 주세요.";

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
}
