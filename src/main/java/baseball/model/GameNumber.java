package baseball.model;

import java.util.List;

public class GameNumber {
    private List<Integer> computerUniqueNumberList;
    private List<Integer> playerUniqueNumberList;
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
