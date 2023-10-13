package baseball;

import baseball.view.input.InputParser;
import baseball.view.input.InputValidator;
import baseball.view.input.console.ConsoleInputManager;
import baseball.view.input.InputManager;
import baseball.view.input.console.ConsoleInputParser;
import baseball.view.input.console.ConsoleInputValidator;
import baseball.view.output.console.ConsoleOutputManager;
import baseball.view.output.OutputManager;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame(outputManager(), inputManager(),gameManager());
        baseballGame.intro();
        baseballGame.runGame();
    }

    private static OutputManager outputManager() {
        return new ConsoleOutputManager();
    }
    private static InputManager inputManager() {
        return new ConsoleInputManager();
    }
    private static InputParser inputParser() { return new ConsoleInputParser(); }
    private static InputValidator inputValidator() { return new ConsoleInputValidator(); }
    private static GameManager gameManager() {
        return new GameManager(inputParser(), inputValidator());
    }

}
