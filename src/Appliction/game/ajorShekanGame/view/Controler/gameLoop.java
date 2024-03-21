package Appliction.game.ajorShekanGame.view.Controler;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Ball;
import Appliction.game.ajorShekanGame.view.model.Brick;
import Appliction.game.ajorShekanGame.view.model.CreatBrick;
import Appliction.view.GameFrame;

import java.util.ArrayList;

public class gameLoop extends Thread {
    public static int CurrentValue = 0;
    public static int BALLSPEED = 35;
    private static int GenBrickSpeed = 600;
    private boolean IsBallTrow = false;
    private boolean IsGameRunning = true;
    public boolean IsGamePus = false;
    public boolean isBallTrow = false;

    public gameLoop() {
        CurrentValue = 0;
    }

    @Override
    public void run() {
        while (IsGameRunning) {
            Update();
        }
    }

    private void Update() {
        CreatBrick();
        MoveBall();
        LoseCheck();
        IsBallTrow = IsBalllTrow();
        if (!IsBallTrow) {
            GamePanel.StartX = -1;
        }
    }

    public boolean IsBalllTrow() {
        for (Ball ball : GamePanel.getGamePanel().ballArrayList) {
            if (ball.IsMoving) {
                return true;
            }
        }
        return false;
    }

    private void CreatBrick() {
        if (!IsGamePus && !isBallTrow) {
            if (GamePanel.getGamePanel().firstBrick.isEmpty() || GamePanel.getGamePanel().firstBrick.get(0).getY() > 0) {
                CurrentValue++;
                GamePanel.getGamePanel().firstBrick = new ArrayList<>();
                new CreatBrick(10, CurrentValue, GamePanel.getGamePanel()).BulAnSatr();
            }
            for (Brick br : GamePanel.getGamePanel().getBrickArrayList()) {
                br.Gravity();
            }
            GameFrame.getGameFrame().repaint();
            try {
                sleep(GenBrickSpeed);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void LoseCheck() {
        for (Brick br : GamePanel.getGamePanel().brickArrayList) {
            if (br.getY() + br.getHeight() > 500) {
                IsGameRunning = false;
            }
        }
    }

    private void MoveBall() {
        if (!IsGamePus && isBallTrow) {
            for (int i = 0; i < GamePanel.getGamePanel().ballArrayList.size(); i++) {
                if (i != GamePanel.getGamePanel().ballArrayList.size() - 1) {
                    GamePanel.getGamePanel().ballArrayList.get(i + 1).setyVal(GamePanel.getGamePanel().ballArrayList.get(i).getyVal());
                    GamePanel.getGamePanel().ballArrayList.get(i + 1).setxVal(GamePanel.getGamePanel().ballArrayList.get(i).getxVal());
                }
                for (int j = 0; j <= i; j++) {
                    GamePanel.getGamePanel().ballArrayList.get(j).Move();
                }
                try {
                    sleep(BALLSPEED);
                } catch (InterruptedException e) {
                }
            }
            while (isBallTrow) {
                for (int i = 0; i < GamePanel.getGamePanel().ballArrayList.size(); i++) {
                    GamePanel.getGamePanel().ballArrayList.get(i).Move();
                }
                try {
                    sleep(BALLSPEED);
                } catch (InterruptedException e) {
                }
                IsBallTrow = IsBalllTrow();
            }
        }
    }
}