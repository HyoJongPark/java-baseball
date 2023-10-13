package baseball.service;

import baseball.view.input.InputParser;
import baseball.view.input.InputValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.GameConst.*;

public class GameManager {
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final List<Integer> uniqueNumbers;
    private boolean gameFinished;
    public GameManager(InputParser inputParser, InputValidator inputValidator) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
        uniqueNumbers = new ArrayList<>();
        gameFinished = false;
    }
    public void generateUniqueNumbers() {
        // 서로 다른 숫자 NUMBER_OF_DIGITS 개 생성 (3개)
        while (uniqueNumbers.size() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
            }
        }
    }
    public String checkPlayerGuessInput(String input) {
        List<Integer> playerInput = inputParser.parse(input);
        inputValidator.isValidInput(playerInput);
        return comparePlayerInput(playerInput);
    }

    public String comparePlayerInput(List<Integer> playerInput) {
        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            int computerNumber = uniqueNumbers.get(i);
            int playerNumber = playerInput.get(i);

            if (playerNumber == computerNumber) {
                strikes++;
            } else if (uniqueNumbers.contains(playerNumber)) {
                balls++;
            }
        }
        if (strikes == NUMBER_OF_DIGITS) {
            this.gameFinished = true;
        }
        return String.valueOf(GameResult.createResult(strikes, balls));
    }
    public boolean isGameFinished() {
        return gameFinished;
    }
    public void reset() {
        this.gameFinished = false;
        this.uniqueNumbers.clear();
        generateUniqueNumbers();
    }
}
