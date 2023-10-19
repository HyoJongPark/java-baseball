package baseball.view;

public class OutputVIew {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

    public void printStartGame() {
        displayMessage(GAME_START_MESSAGE);
    }

    public void printEndGame() {
        displayMessage(GAME_END_MESSAGE);
    }

    public void printHint(String hintMessage) {
        displayMessage(hintMessage + "\n");
    }
    private void displayMessage(String message) {
        System.out.print(message);
    }
}
