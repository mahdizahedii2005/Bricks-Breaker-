package Appliction.game.ajorShekanGame.view;

public class ScoreHandeler {
    private long currentScore =0;
    TimeHandeler timeHandeler;

    public ScoreHandeler(TimeHandeler t) {
        timeHandeler = t;
    }
    public void increaseScore(int value){
        currentScore += value-timeHandeler.giveSecond();
    }
}
