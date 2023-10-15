package baseball.service;

import baseball.view.input.InputParser;
import baseball.view.input.InputValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.constant.GameConst.*;

public class GameManager {
    private final List<Integer> uniqueNumbers;
    private boolean gameFinished;
    public GameManager() {
        uniqueNumbers = new ArrayList<>();
        gameFinished = false;
    }
    public void generateUniqueNumberList() {
        while (uniqueNumbers.size() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
            if (isUniqueNumber(randomNumber)) {
                appendUniqueNumber(randomNumber);
            }
        }
    }
    private boolean isUniqueNumber(int number) {
        return !uniqueNumbers.contains(number);
    }
    private void appendUniqueNumber(int number) {
        uniqueNumbers.add(number);
    }

    public String comparePlayerInput(List<Integer> playerInput) {
        int strikes = countStrikes(playerInput);
        int balls = countBalls(playerInput);
        if (strikes == NUMBER_OF_DIGITS) {
            this.gameFinished = true;
        }
        return String.valueOf(GameResult.createResult(strikes, balls));
    }
    private int countStrikes(List<Integer> playerInput) {
        int strikes = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            if (playerInput.get(i) == uniqueNumbers.get(i)) {
                strikes++;
            }
        }
        return strikes;
    }
    private int countBalls(List<Integer> playerInput) {
        int balls = 0;
        for (int i = 0; i < NUMBER_OF_DIGITS; i++) {
            if (uniqueNumbers.contains(playerInput.get(i))
                    && uniqueNumbers.get(i) != playerInput.get(i)) {
                balls++;
            }
        }
        return balls;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }
    public void reset() {
        this.gameFinished = false;
        this.uniqueNumbers.clear();
    }
}
