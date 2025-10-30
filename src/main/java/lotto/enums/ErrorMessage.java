package lotto.enums;

public enum ErrorMessage {
    BLANK_INPUT("[ERROR] 빈 문자열이 입력되었습니다. 다시 입력해 주세요."),
    NOT_ONLY_DIGIT("[ERROR] 숫자를 제외한 문자가 포함되어 있습니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
