package baseball;

public class MessageManager {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    MessageManager() {}
    public void gameStart() {
        displayMessage(GAME_START_MESSAGE);
    }
    private void displayMessage(String message) {
        System.out.println(message);
        }
    }