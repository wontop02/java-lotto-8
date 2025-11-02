package lotto.domain;

import static lotto.constant.ErrorMessageConstant.INVALID_PURCHASE_AMOUNT_RANGE;
import static lotto.constant.ErrorMessageConstant.INVALID_PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("구입 금액이 로또 하나의 금액 미만이면 예외가 발생한다.")
    @Test
    void 구입_금액이_로또_하나의_금액_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_RANGE);
    }

    @DisplayName("구입 금액이 최대 구입 금액을 초과하면 예외가 발생한다.")
    @Test
    void 구입_금액이_최대_구입_금액을_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(200_000_000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_RANGE);
    }

    @DisplayName("구입 금액이 로또 하나의 금액으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입_금액이_로또_하나의_금액으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount(15_500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_UNIT);
    }
}
