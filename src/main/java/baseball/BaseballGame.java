package baseball;

import baseball.view.input.InputManager;
import baseball.view.output.OutputManager;

public class BaseballGame {
    private final OutputManager outputManager;
    private final InputManager inputManager;
    private final GameManager gameManager;

    BaseballGame(OutputManager outputManager, InputManager inputManager, GameManager gameManager) {
        this.outputManager = outputManager;
        this.inputManager = inputManager;
        this.gameManager = gameManager;
    }
    public void intro() {
        outputManager.gameStartMessage();
    }
    public void runGame() {
        gameManager.generateUniqueNumbers();
        //System.out.println(gameManager.getUniqueNumbers());
        while (!gameManager.isGameFinished()) {
            playGame();
        }
        outputManager.gameWinMessage();
        outputManager.gameEndPrompt();
        handleGameContinuation();
    }
    private void playGame() {
        outputManager.userInputPromptMessage();
        String playerInput = inputManager.getPlayerInput();
        outputManager.gameResult(gameManager.checkPlayerGuessInput(playerInput));
    }
    private void handleGameContinuation() {
        GameDecision decision = gameManager.decideGameContinuation(inputManager.getPlayerInput());

        if (decision == GameDecision.RESTART) {
            gameManager.reset();
            runGame();
        } else if (decision == GameDecision.EXIT) {
        }
    }
}
