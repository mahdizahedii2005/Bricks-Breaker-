package Appliction.game.ajorShekanGame.view.Controler;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Ball;
import Appliction.game.ajorShekanGame.view.model.Brick;
import Appliction.game.ajorShekanGame.view.model.CreatBrick;
import Appliction.game.ajorShekanGame.view.model.Gravity;
import Appliction.view.GameFrame;

public class gameLoop extends Thread {
    public int SpeedOfBrickP = 10;
    public static int CurrentValue = 1;
    public static int BALLSPEED = 35;
    private static int GenBrickSpeed = 600;
    private boolean IsBallTrow = false;
    private boolean IsGameRunning = true;
    public boolean IsGamePus = false;
    public boolean isBallTrow = false;

    public gameLoop() {
        CurrentValue = 1;
    }

    @Override
    public void run() {
        while (IsGameRunning) {
            Update();
        }
    }

    private void Update() {
        Creatsatr();
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

    private void MoveDownOneStep(int arz) {
        for (Gravity br : GamePanel.getGamePanel().gravityObject) {
            br.Gravity(500 / arz);
        }
    }

    private void Creatsatr() {
        if (!IsGamePus && !isBallTrow) {
            if (GamePanel.getGamePanel().firstBrick.isEmpty() || GamePanel.getGamePanel().firstBrick.get(0).getY() > 0) {
                new CreatBrick(GamePanel.NUMBEROFBRICKINEACHSATR, CurrentValue, GamePanel.getGamePanel()).BulAnSatr();
            }
            for (Gravity GR : GamePanel.getGamePanel().gravityObject) {
                GR.Gravity(SpeedOfBrickP);
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
            int j = 0;
            while (isBallTrow) {
                j++;
                for (int i = 0; i < GamePanel.getGamePanel().ballArrayList.size(); i++) {
                    GamePanel.getGamePanel().ballArrayList.get(i).Move();
                }
                try {
                    sleep(BALLSPEED);
                } catch (InterruptedException e) {
                }
                IsBallTrow = IsBalllTrow();
            }
            new CreatBrick(GamePanel.NUMBEROFBRICKINEACHSATR, CurrentValue, GamePanel.getGamePanel()).CustomCreat();
            MoveDownOneStep(GamePanel.NUMBEROFBRICKINEACHSATR);
            new Ball(GamePanel.StartX, GamePanel.startY, 15, 15, GamePanel.getGamePanel().ballPAth);
        }
    }
}