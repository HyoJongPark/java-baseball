package baseball;

public class ConsoleManager {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_INPUT_PROMPT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public void gameStartMessage() { displayMessage(GAME_START_MESSAGE); }
    public void userInputPromptMessage() { displayMessage(GAME_INPUT_PROMPT_MESSAGE); }
    public void gameWinMessage() { displayMessage(GAME_WIN_MESSAGE); }
    public void gameEndPrompt() { displayMessage(GAME_END_MESSAGE); }
    private void displayMessage(String message) { System.out.println(message); }
}