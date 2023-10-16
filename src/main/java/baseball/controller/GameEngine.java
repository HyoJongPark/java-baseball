package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputVIew;

public class GameEngine {
    private final InputView inputView;
    private final OutputVIew outputView;
    private final GameProcessor gameProcessor;
    private final GameNumber gameNumber;

    public GameEngine(InputView inputView, OutputVIew outputView, GameProcessor gameProcessor, GameNumber gameNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameProcessor = gameProcessor;
        this.gameNumber = gameNumber;
    }

    public void run() {
        outputView.printStartGame();
        gameProcessor.setting(gameNumber);
        playGameUntilPlayerWin();
        outputView.printEndGame();
    }

    private void playGameUntilPlayerWin() {
        boolean isCorrect = false;
        while (!isCorrect) {
            inputView.askForNumbers();
            isCorrect = gameProcessor.compare(gameNumber);
        }
    }
}
