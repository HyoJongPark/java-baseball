package baseball.view.input.console;

import baseball.view.input.InputManager;

import java.util.Scanner;

public class ConsoleInputManager implements InputManager {
    private final Scanner scanner;
    public ConsoleInputManager() {
        this.scanner = new Scanner(System.in);
    }
    @Override
    public String getPlayerInput() {
        String input = scanner.nextLine();
        return input;
    }
}
