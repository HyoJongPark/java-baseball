package baseball.service;

import baseball.model.GameData;

import java.util.List;

public class GameService {
    private static final int NUMBER_SIZE = 3;
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String SPACE_MESSAGE = " ";
    private static final String BLANK = "";
    private static final String RESTART = "1";
    private static final String EXIT = "2";
    private int strikeCount;
    private int ballCount;

    private final NumberService numberService;

    public GameService(NumberService numberService) {
        this.numberService = numberService;
    }
    public void setting(GameData gameData) {
        List<Integer> computerNumberList = numberService.generateUniqueNumberList();
        gameData.setComputerUniqueNumberList(computerNumberList);
    }

    public boolean compareNumberList(GameData gameData) {
        initCount();
        compare(gameData.getComputerUniqueNumberList(), gameData.getPlayerUniqueNumberList());
        return isThreeStrike();
    }
    private boolean isThreeStrike() {
        return strikeCount == 3;
    }
    public String getCompareResultToString() {
        String hintMessage = "";
        hintMessage += getBallHintMessage();
        hintMessage += getStrikeHintMessage();
        hintMessage += getNotingHintMessage();
        return hintMessage;
    }
    private String getBallHintMessage() {
        if (ballCount > 0) {
            return ballCount + BALL_MESSAGE + SPACE_MESSAGE;
        }

        return BLANK;
    }
    private String getStrikeHintMessage() {
        if (strikeCount > 0) {
            return strikeCount + STRIKE_MESSAGE;
        }

        return BLANK;
    }

    private String getNotingHintMessage() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING_MESSAGE;
        }

        return BLANK;
    }


    private void compare(List<Integer> computerNumberList, List<Integer> playerNumberList) {
        for (int i = 0; i < NUMBER_SIZE; i++) {
            countBall(computerNumberList, getPlayerNumber(playerNumberList, i), i);
            countStrike(getComputerNumber(computerNumberList, i), getPlayerNumber(playerNumberList, i));
        }
    }
    private void initCount() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }
    private Integer getComputerNumber(List<Integer> computerNumberList, int i) {
        return computerNumberList.get(i);
    }
    private Integer getPlayerNumber(List<Integer> playerNumberList, int i) {
        return playerNumberList.get(i);
    }
    private void countBall(List<Integer> computerNumberList, int playerNumber, int playerNumberIndex) {
        if (computerNumberList.contains(playerNumber)
                && computerNumberList.get(playerNumberIndex) != playerNumber) {
            this.ballCount++;
        }
    }
    private void countStrike(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            this.strikeCount++;
        }
    }

    public void restart(String input, GameData gameData) {
        if (input.equals(EXIT)) {
            gameData.setGameFinished(true);
        }
    }
}
