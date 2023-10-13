package baseball.view.input.console;

import baseball.view.input.InputParser;

import java.util.ArrayList;
import java.util.List;

public class ConsoleInputParser implements InputParser {
    @Override
    public List<Integer> parse(String input) {
        List<Integer> playerInput = new ArrayList<>();
        String[] inputTokens = input.split("");
        for (String token : inputTokens) {
            int number = Integer.parseInt(token);
            playerInput.add(number);
        }
        return playerInput;
    }
}
