package baseball.view.input.console;

import baseball.view.input.InputValidator;

import java.util.List;

import static baseball.constant.GameConst.*;

public class ConsoleInputValidator implements InputValidator {
    @Override
    public boolean isValidInput(List<Integer> playerInput) {
        if (playerInput.size() != NUMBER_OF_DIGITS) {
            throw new IllegalArgumentException(NUMBER_OF_DIGITS + "개의 숫자를 입력하세요.");
        }

        for (int number : playerInput) {
            if (playerInput.indexOf(number) != playerInput.lastIndexOf(number)) {
                throw new IllegalArgumentException("중복되지 않는 숫자 " + NUMBER_OF_DIGITS + "개를 입력하세요.");
            }
            if (number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
                throw new IllegalArgumentException(MIN_RANDOM_NUMBER + "부터 " + MAX_RANDOM_NUMBER + "까지 " +
                        "중복되지 않는 숫자 " + NUMBER_OF_DIGITS + "개를 입력하세요.");
            }
        }

        return true;
    }
}
