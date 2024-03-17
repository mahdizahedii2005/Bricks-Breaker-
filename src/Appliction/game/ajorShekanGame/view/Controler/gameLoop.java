package Appliction.game.ajorShekanGame.view.Controler;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Brick;
import Appliction.game.ajorShekanGame.view.model.CreatBrick;
import Appliction.view.GameFrame;

import java.util.ArrayList;

public class gameLoop extends Thread {
    private boolean IsGameRunning = true;
    public boolean IsGamePus = false;

    @Override
    public void run() {
        while (IsGameRunning) {
            Update();
        }
    }

    private void Update() {
        if (!IsGamePus) {
            boolean firstB = true;
            if (GamePanel.getGamePanel().firstBrick.isEmpty() || GamePanel.getGamePanel().firstBrick.get(0).getY() > 0) {
                int valu = 1;
                if (!GamePanel.getGamePanel().firstBrick.isEmpty()) {
                    valu = GamePanel.getGamePanel().firstBrick.get(0).getValue() + 1;
                }
                GamePanel.getGamePanel().firstBrick = new ArrayList<>();
                new CreatBrick(10, valu, GamePanel.getGamePanel()).BulAnSatr();
            }
            for (Brick br : GamePanel.getGamePanel().getBrickArrayList()) {
                br.Gravity();
            }
            GameFrame.getGameFrame().repaint();
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (Brick br : GamePanel.getGamePanel().brickArrayList) {
            if (br.getY() + br.getHeight() > 500) {
                IsGameRunning = false;
            }

        }
    }
}
