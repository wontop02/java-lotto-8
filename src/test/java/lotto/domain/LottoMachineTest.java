package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    @DisplayName("구입 금액에 해당하는 만큼 로또를 발행한다.")
    @Test
    void 구입_금액에_해당하는_만큼_로또를_발행한다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(10000);
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);
        
        List<Lotto> lottos = lottoMachine.issue();

        assertEquals(10, lottos.size());
    }
}
