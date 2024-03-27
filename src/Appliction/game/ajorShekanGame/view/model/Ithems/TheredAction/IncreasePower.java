package Appliction.game.ajorShekanGame.view.model.Ithems.TheredAction;

import Appliction.game.ajorShekanGame.view.GameState;
import Appliction.game.ajorShekanGame.view.model.Brick;

public class IncreasePower extends Thread {
    @Override
    public void run() {
        Brick.BALL_POWER = 2;
        for (int i = 0; i < 150; i++) {
            while (!GameState.isGameStop) {
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Brick.BALL_POWER = 1;
    }
}
