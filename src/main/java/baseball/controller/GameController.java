package baseball.controller;

import baseball.model.GameData;
import baseball.service.GameService;
import baseball.service.NumberService;
import baseball.validator.NumberValidator;
import baseball.view.InputView;
import baseball.view.OutputVIew;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputVIew outputView;
    private final GameService gameService;
    private final NumberService numberService;
    private GameData gameData;
    private final NumberValidator numberValidator;

    public GameController(InputView inputView, OutputVIew outputView, GameService gameProcessor, NumberService numberService, GameData gameNumber, NumberValidator numberValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameService = gameProcessor;
        this.numberService = numberService;
        this.gameData = gameNumber;
        this.numberValidator = numberValidator;
    }

    public void run() {
        while (!gameData.getGameFinished()) {
            outputView.printStartGame();
            gameService.setting(gameData);
            playGameUntilPlayerWin();
            outputView.printEndGame();
            askForRestart(gameData);
        }
    }

    private void playGameUntilPlayerWin() {
        boolean isCorrect = false;
        while (!isCorrect) {
            askForNumbersAndSave();
            isCorrect = gameService.compareNumberList(gameData);
            outputView.printHint(gameService.getCompareResultToString());
        }
    }

    private void askForNumbersAndSave() {
        String input = inputView.askForNumbers();
        List<Integer> playerNumberList = numberValidator.validate(numberService.convertStringToIntList(input));
        gameData.setPlayerUniqueNumberList(playerNumberList);
    }

    private void askForRestart(GameData gameData) {
        gameService.restart(inputView.askForRestart(), gameData);
    }

}
