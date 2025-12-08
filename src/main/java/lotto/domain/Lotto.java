package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final String INVALID_SIZE = "로또 번호는 6개여야 합니다.";
    private static final String CAN_NOT_DUPLICATED = "로또 번호는 중복될 수 없습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
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

    @Override
    public String toString() {
        return numbers.toString();
    }
}
