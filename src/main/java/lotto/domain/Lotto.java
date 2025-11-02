package lotto.domain;

import static lotto.constant.ErrorMessageConstant.DUPLICATED_LOTTO_NUMBER;
import static lotto.constant.ErrorMessageConstant.INVALID_LOTTO_NUMBER_SIZE;
import static lotto.constant.ErrorMessageConstant.INVALID_NUMBER_RANGE;
import static lotto.constant.LottoConstant.LOTTO_NUMBER_SIZE;
import static lotto.constant.LottoConstant.MAX_NUMBER;
import static lotto.constant.LottoConstant.MIN_NUMBER;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_SIZE);
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER);
        }
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }
}
