package lotto.domain;

import static lotto.enums.ErrorMessage.INVALID_PURCHASE_AMOUNT_RANGE;
import static lotto.enums.ErrorMessage.INVALID_PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    @DisplayName("구입 금액이 1,000원 미만이면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_RANGE.getMessage());
    }

    @DisplayName("구입 금액이 100,000,000원을 초과하면 예외가 발생한다.")
    @Test
    void 구입_금액이_100000000원을_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("200000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_RANGE.getMessage());
    }

    @DisplayName("구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("15500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_UNIT.getMessage());
    }
}
