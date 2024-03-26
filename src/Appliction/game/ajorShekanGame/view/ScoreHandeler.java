package Appliction.game.ajorShekanGame.view;

public class ScoreHandeler {
    private Long currentScore = 0L;
    private TimeHandeler timeHandeler;
    private Long lastScore = 0L;

    public ScoreHandeler(TimeHandeler t) {
        timeHandeler = t;
    }

    public Long getCurrentScore() {
        if (GamePanel.getGamePanel().gameLoop.IsGameRunning&&!GamePanel.getGamePanel().gameLoop.IsGamePus) {
            lastScore = currentScore - timeHandeler.giveSecond();
            return currentScore - timeHandeler.giveSecond();
        } else {
            return lastScore;
        }
    }

    public void increaseScore(int value) {
        currentScore += (value);
    }
}
