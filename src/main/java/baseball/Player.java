package baseball;

import java.util.ArrayList;
import java.util.List;

/**
 * 아직 사용하지 않음, 플레이어의 입력값 (123, 321) 등 숫자를 저장할 객체로 이용 하려 했으나, 아직 고민중
 * */
public class Player {
    private final List<Integer> playerInput;

    public Player(List<Integer> input) {
        playerInput = input;
    }

    public List<Integer> getPlayerInput() {
        return playerInput;
    }

    public void clearInput() {
        playerInput.clear();
    }
}
