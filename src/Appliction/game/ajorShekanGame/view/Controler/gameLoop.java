package Appliction.game.ajorShekanGame.view.Controler;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Brick;
import Appliction.game.ajorShekanGame.view.model.CreatBrick;
import Appliction.view.GameFrame;

import java.util.ArrayList;

public class gameLoop extends Thread {
    public static int BALLSPEED = 120;
    private boolean IsBallTrow = false;
    private boolean IsGameRunning = true;
    public boolean IsGamePus = false;
    public boolean isBallTrow = false;

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
    }

    private void CreatBrick() {
        if (!IsGamePus && !isBallTrow) {
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
            try {
                sleep(1000);
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
//            for (int i = 0; i < GamePanel.getGamePanel().ballArrayList.size(); i++) {
//                if (i != GamePanel.getGamePanel().ballArrayList.size() - 1) {
//                    GamePanel.getGamePanel().ballArrayList.get(i + 1).setyVal(GamePanel.getGamePanel().ballArrayList.get(i).getyVal());
//                    GamePanel.getGamePanel().ballArrayList.get(i + 1).setxVal(GamePanel.getGamePanel().ballArrayList.get(i).getxVal());
//                }
//                GamePanel.getGamePanel().ballArrayList.get(i).Move();
//                try {
//                    sleep(BALLSPEED);
//                } catch (InterruptedException e) {
//                }
//            }
            while (true /*todo barkhord*/) {
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
                while (true) {
                    for (int i = 0; i < GamePanel.getGamePanel().ballArrayList.size(); i++) {
                        GamePanel.getGamePanel().ballArrayList.get(i).Move();
                    }
                    try {
                    sleep(BALLSPEED);
                } catch (InterruptedException e) {
                }
                }
            }
        }
    }
}