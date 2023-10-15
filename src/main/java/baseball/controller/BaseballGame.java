package baseball.controller;

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
        checkRestart();
    }
    private void playGame() {
        outputManager.userInputPromptMessage();
        List<Integer> inputParse = inputParse(getInput());
        inputValidator.isValidInput(inputParse);
        outputManager.gameResult(gameManager.checkPlayerGuessInput(inputParse));
    }
    private String getInput() {
        return inputManager.getPlayerInput();
    }
    private List<Integer> inputParse(String input) {
        return inputParser.parse(input);
    }
    private void checkRestart() {
        if (gameManager.checkForGameRestart(getInput())) {
            this.runGame();
        }
    }
}
