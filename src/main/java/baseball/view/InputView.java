package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
    public String askForNumbers() {
        displayMessage(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String askForRestart() {
        displayMessage(INPUT_RESTART_GAME_MESSAGE);
        return Console.readLine();
    }

    private void displayMessage(String message) {
        System.out.print(message);
    }
}
