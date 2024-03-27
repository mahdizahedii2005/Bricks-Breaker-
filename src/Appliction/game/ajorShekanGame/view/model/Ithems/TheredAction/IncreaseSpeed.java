package Appliction.game.ajorShekanGame.view.model.Ithems.TheredAction;

import Appliction.game.ajorShekanGame.view.Controler.gameLoop;
import Appliction.game.ajorShekanGame.view.GameState;

public class IncreaseSpeed extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 150; i++) {
            gameLoop.BALLSPEED = 20;
            while (!GameState.isGameStop) {
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        gameLoop.BALLSPEED = 30;
    }
}
