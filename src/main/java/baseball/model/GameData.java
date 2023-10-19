package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class GameData {
    private boolean gameFinished;
    private List<Integer> computerUniqueNumberList;
    private List<Integer> playerUniqueNumberList;

    public GameData() {
        this.gameFinished = false;
        this.computerUniqueNumberList = new ArrayList<>();
        this.playerUniqueNumberList = new ArrayList<>();
    }

    public void setGameFinished(boolean gameFinished) {
        this.gameFinished = gameFinished;
    }
    public boolean getGameFinished() {
        return gameFinished;
    }
    public List<Integer> getComputerUniqueNumberList() {
        return computerUniqueNumberList;
    }

    public void setComputerUniqueNumberList(List<Integer> computerUniqueNumberList) {
        this.computerUniqueNumberList = computerUniqueNumberList;
    }

    public List<Integer> getPlayerUniqueNumberList() {
        return playerUniqueNumberList;
    }

    public void setPlayerUniqueNumberList(List<Integer> playerUniqueNumberList) {
        this.playerUniqueNumberList = playerUniqueNumberList;
    }
}
