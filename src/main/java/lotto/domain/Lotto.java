package lotto.domain;

import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String INVALID_SIZE = "로또 번호는 6개여야 합니다.";
    private static final String CAN_NOT_DUPLICATED = "로또 번호는 중복될 수 없습니다.";
    private static final String INVALID_NUMBER_RANGE =
            String.format(
                    "로또 번호는 %d에서 %d 사이여야 합니다.",
                    MIN_NUMBER, MAX_NUMBER
            );

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        this.numbers = sorted;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateNumberRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(CAN_NOT_DUPLICATED);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_NUMBER || number > MAX_NUMBER) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> numbers() {
        return List.copyOf(numbers);
    }
}
