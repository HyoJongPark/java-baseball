package baseball;

public enum GameDecision {
    RESTART("1"), // 게임 재시작
    EXIT("2");     // 게임 완전히 종료
    private final String command;
    GameDecision(String command) {
        this.command = command;
    }
    public String getCommand() {
        return command;
    }
}
