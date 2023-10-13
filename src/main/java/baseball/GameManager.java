package baseball;

import baseball.view.input.InputParser;
import baseball.view.input.InputValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.GameConst.*;

public class GameManager {
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final List<Integer> uniqueNumbers;
    private boolean gameFinished;
    GameManager(InputParser inputParser, InputValidator inputValidator) {
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
        uniqueNumbers = new ArrayList<>();
        gameFinished = false;
    }
    public List<Integer> getUniqueNumbers() {
        return uniqueNumbers;
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

    public String checkPlayerGuessInput(String input) throws IllegalArgumentException {
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

    // 게임 종료 후, 플레이어 입력 값에 따라 재시작 또는 완전히 종료를 결정하는 로직
    public GameDecision decideGameContinuation(String input) throws IllegalArgumentException {
        for (GameDecision decision : GameDecision.values()) {
            if (decision.getCommand().equals(input)) {
                return decision;
            }
        }
        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }

    public void reset() {
        this.gameFinished = false;
        this.uniqueNumbers.clear();
        generateUniqueNumbers();
    }
}
