package baseball.controller;

import baseball.service.GameDecision;
import baseball.service.GameManager;
import baseball.view.input.InputManager;
import baseball.view.input.InputParser;
import baseball.view.input.InputValidator;
import baseball.view.output.OutputManager;

import java.util.List;

public class BaseballGame {
    private final OutputManager outputManager;
    private final InputManager inputManager;
    private final InputParser inputParser;
    private final InputValidator inputValidator;
    private final GameManager gameManager;

    public BaseballGame(OutputManager outputManager, InputManager inputManager, InputParser inputParser, InputValidator inputValidator, GameManager gameManager) {
        this.outputManager = outputManager;
        this.inputManager = inputManager;
        this.inputParser = inputParser;
        this.inputValidator = inputValidator;
        this.gameManager = gameManager;
    }
    public void intro() {
        outputManager.gameStartMessage();
    }
    public void runGame() {
        gameManager.generateUniqueNumberList();
        while (!gameManager.isGameFinished()) {
            playGame();
        }
        outputManager.gameWinMessage();
        outputManager.gameEndPrompt();
        checkRestart(inputManager.getPlayerInput());
    }
    private void playGame() {
        outputManager.userInputPromptMessage();
        List<Integer> inputParse = inputParser.parse(inputManager.getPlayerInput());
        inputValidator.isValidInput(inputParse);
        outputManager.gameResult(gameManager.comparePlayerInput(inputParse));
    }
    private void checkRestart(String input) {
        if (GameDecision.decideGameContinuation(input)) {
            gameManager.reset();
            runGame();
        }
    }
}
