package lotto.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static lotto.enums.ErrorMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.enums.ErrorMessage.INVALID_LOTTO_NUMBER_SIZE;
import static lotto.enums.ErrorMessage.INVALID_NUMBER_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static Stream<Runnable> invalidNumberRangeInput() {
        return Stream.of(
                () -> new Lotto(List.of(0, 1, 2, 3, 4, 5)),
                () -> new Lotto(List.of(46, 1, 2, 3, 4, 5))
        );
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_NUMBER_SIZE.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 최소 최대 범위를 벗어나면 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("invalidNumberRangeInput")
    void 로또_번호가_최소_최대_범위를_벗어나면_예외가_발생한다(Runnable lottoConstructor) {
        assertThatThrownBy(lottoConstructor::run)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_NUMBER_RANGE.getMessage());
    }
}
