package lotto.enums;

public enum ErrorMessage {
    BLANK_INPUT("빈 문자열이 입력되었습니다."),
    NOT_ONLY_DIGIT("숫자를 제외한 문자가 포함되어 있습니다."),
    NOT_DIGITS_AND_COMMA_ONLY("숫자와 쉼표(,)를 제외한 문자가 포함되어 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
