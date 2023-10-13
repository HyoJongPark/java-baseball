package baseball.view.output.console;

import baseball.view.output.AbstractOutputManager;

public class ConsoleOutputManager extends AbstractOutputManager {
    @Override
    protected void displayMessage(String message) { System.out.print(message); }
}