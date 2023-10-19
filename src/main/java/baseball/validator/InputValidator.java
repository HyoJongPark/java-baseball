package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final int NUMBER_SIZE = 3;
    private static final String ERROR_LENGTH_INPUT_MESSAGE = "숫자 세 자리를 입력해주세요.";
    private static final String ERROR_RANGE_INPUT_MESSAGE = "1 ~ 9 사이의 숫자만 입력 가능합니다.";
    private static final String ERROR_DUPLICATE_NUMBER_INPUT_MESSAGE = "서로 다른 세 자리의 숫자만 입력 가능합니다";

    public void validate(String input) {
        validateLength(input);
        validateRange(input);
        validateDuplicate(input);
    }

    private void validateLength(String input) {
        if (input.length() != NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_LENGTH_INPUT_MESSAGE);
        }
    }

    private void validateRange(String input) {
        for (char c : input.toCharArray()) {
            int digit = Character.getNumericValue(c);
            if (digit < 1 || digit > 9) {
                throw new IllegalArgumentException(ERROR_RANGE_INPUT_MESSAGE);
            }
        }
    }

    private void validateDuplicate(String input) {
        Set<Character> charSet = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!charSet.add(c)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBER_INPUT_MESSAGE);
            }
        }
    }
}
