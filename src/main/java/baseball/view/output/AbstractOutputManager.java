package baseball.view.output;

import static baseball.view.output.MessageConst.*;

public abstract class AbstractOutputManager implements OutputManager {
    public void gameStartMessage() {
        displayMessage(GAME_START_MESSAGE);
    }

    public void userInputPromptMessage() {
        displayMessage(GAME_INPUT_PROMPT_MESSAGE);
    }

    public void gameWinMessage() {
        displayMessage(GAME_WIN_MESSAGE);
    }

    public void gameEndPrompt() {
        displayMessage(GAME_END_MESSAGE);
    }

    public void errorMessage(String error) {
        displayMessage(error);
    }

    public void gameResult(String result) { displayMessage(result + LINE); }

    protected abstract void displayMessage(String message);
}
