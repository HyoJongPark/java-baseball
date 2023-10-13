package baseball.view.input;

import java.util.List;

public interface InputValidator {
    boolean isValidInput(List<Integer> playerInput) throws IllegalArgumentException;
}