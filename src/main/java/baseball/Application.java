package baseball;

import baseball.controller.GameController;
import baseball.model.GameData;
import baseball.service.GameService;
import baseball.service.NumberService;
import baseball.validator.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputVIew;

public class Application {
    public static void main(String[] args) {
        GameController engin = new GameController(inputView(), outputView(), gameService(), numberService(), gameNumber(), inputValidator());
        engin.run();
    }

    private static InputValidator inputValidator() {
        return new InputValidator();
    }

    private static final InputView inputView() {
        return new InputView();
    }
    private static final OutputVIew outputView() {
        return new OutputVIew();
    }
    private static final GameService gameService() {
        return new GameService(numberService());
    }
    private static final GameData gameNumber() {
        return new GameData();
    }

    private static final NumberService numberService() {
        return new NumberService();
    }
}
