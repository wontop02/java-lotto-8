package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {
    private static final String INVALID_PURCHASE_AMOUNT_RANGE =
            "구입 금액은 1,000원 이상, 100,000,000원 이하의 숫자여야 합니다.";

    @DisplayName("구입 금액이 1,000원 미만이면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_PURCHASE_AMOUNT_RANGE);
    }
}
