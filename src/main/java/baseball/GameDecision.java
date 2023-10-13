package baseball;

public enum GameDecision {
    RESTART("1"), // 게임 재시작
    EXIT("2");     // 게임 완전히 종료
    private final String command;
    GameDecision(String command) {
        this.command = command;
    }

    // 게임 종료 후, 플레이어 입력 값에 따라 재시작 또는 완전히 종료를 결정하는 로직
    public static GameDecision decideGameContinuation(String input) {
        for (GameDecision decision : GameDecision.values()) {
            if (decision.command.equals(input)) {
                return decision;
            }
        }
        throw new IllegalArgumentException("1 또는 2를 입력하세요.");
    }
}
