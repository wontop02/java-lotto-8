package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class InputValidatorTest {
    private static final String BLANK_INPUT =
            "[ERROR] 빈 문자열이 입력되었습니다. 다시 한번 입력해 주세요.";
    private static Stream<Runnable> validatorsForBlankInput() {
        return Stream.of(
                () -> InputValidator.validatePurchaseAmount(" "),
                () -> InputValidator.validateWinningNumbers(" "),
                () -> InputValidator.validateBonusNumber(" ")
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
}
