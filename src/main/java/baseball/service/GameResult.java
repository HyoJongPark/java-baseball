package baseball.service;

public enum GameResult {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");
    private final String description;

    GameResult(String description) {
        this.description = description;
    }

    public static String createResult(int strikes, int balls) {
        if (strikes == 0 && balls == 0) {
            return NOTHING.description;
        }

        StringBuilder message = new StringBuilder();
        if (balls > 0) {
            message.append(balls).append(BALL.description + " ");
        }
        if (strikes > 0) {
            message.append(strikes).append(STRIKE.description);
        }

        return String.valueOf(message);
    }


}
