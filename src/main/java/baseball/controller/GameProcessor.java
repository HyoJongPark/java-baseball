package baseball.controller;

import baseball.model.GameNumber;

import java.util.List;

public class GameProcessor {
    private static final int NUMBER_SIZE = 3;
    private int strikeCount;
    private int ballCount;

    private final NumberProcessor numberProcessor;

    public GameProcessor(NumberProcessor numberProcessor) {
        this.numberProcessor = numberProcessor;
    }
    public void setting(GameNumber gameNumber) {
        List<Integer> computerNumberList = numberProcessor.generateUniqueNumberList();
        gameNumber.setComputerUniqueNumberList(computerNumberList);
    }

    public boolean compare(GameNumber gameNumber) {
        init();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            countBall(gameNumber.getComputerUniqueNumberList().get(i), gameNumber.getPlayerUniqueNumberList().get(i));
            countStrike(gameNumber.getComputerUniqueNumberList().get(i), gameNumber.getPlayerUniqueNumberList().get(i));
        }
        return false;
    }

    private void init() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }
    private void countBall(int computerNumber, Integer integer1) {

    }
    private void countStrike(Integer integer, Integer integer1) {

    }
}
