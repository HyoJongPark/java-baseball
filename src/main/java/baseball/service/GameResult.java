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
        StringBuilder message = new StringBuilder();
        appendNothing(message, strikes, balls);
        appendBalls(message, balls);
        appendStrikes(message, strikes);
        return String.valueOf(message);
    }

    private static void appendNothing(StringBuilder message, int balls, int strikes) {
        if (strikes == 0 && balls == 0) {
            message.append(NOTHING.description);
        }
    }
    private static void appendBalls(StringBuilder message, int balls) {
        if (balls > 0) {
            message.append(balls).append(BALL.description).append(" ");
        }
    }

    private static void appendStrikes(StringBuilder message, int strikes) {
        if (strikes > 0) {
            message.append(strikes).append(STRIKE.description);
        }
    }

}
