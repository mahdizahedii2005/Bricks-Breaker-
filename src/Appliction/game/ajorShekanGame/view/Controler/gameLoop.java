package Appliction.game.ajorShekanGame.view.Controler;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Ball;
import Appliction.game.ajorShekanGame.view.model.Brick;
import Appliction.game.ajorShekanGame.view.model.CreatBrick;
import Appliction.game.ajorShekanGame.view.model.Gravity;
import Appliction.view.GameFrame;

public class gameLoop extends Thread {
    public static boolean IS_IT_REV = false;
    public static int HP = 1;
    public static int NUMBER_OF_BALL_TO_IN_THIS_ROUND = 1;
    public int SpeedOfBrickP = 10;
    public static int CurrentValue = 1;
    public static int BALLSPEED = 30;
    private static int GenBrickSpeed = 600;
    private boolean IsBallTrow = false;
    private boolean IsGameRunning = true;
    public boolean IsGamePus = false;
    public boolean isBallTrow = false;

    public gameLoop() {
        CurrentValue = 1;
        if (GamePanel.level.equals("hard")) {
            GenBrickSpeed = 40;
            BALLSPEED = 30;
            SpeedOfBrickP = 1;
        } else if (GamePanel.level.equals("normal")) {
            GenBrickSpeed = 47;
            BALLSPEED = 30;
            SpeedOfBrickP = 1;
        } else if (GamePanel.level.equals("ez")) {
            GenBrickSpeed = 55;
            BALLSPEED = 30;
            SpeedOfBrickP = 1;
        }
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
            int s =0;
            if (GamePanel.level.equals("hard")) {
                s = (500 / arz);
            } else if (GamePanel.level.equals("normal")) {
                s = (250 / arz) ;
            } else if (GamePanel.level.equals("ez")) {
                s = (250 / arz) ;
            }
            br.Gravity(s);
        }
    }

    private void moveRev(int arz) {
        for (Gravity br : GamePanel.getGamePanel().gravityObject) {
            br.Gravity(-500 / arz);
        }
    }

    private void Creatsatr() {
        if (!IsGamePus && !isBallTrow) {
            if (GamePanel.getGamePanel().firstBrick.isEmpty() || GamePanel.getGamePanel().firstBrick.get(0).getY() >= 0) {
                new CreatBrick(GamePanel.NUMBEROFBRICKINEACHSATR, CurrentValue, GamePanel.getGamePanel()).BulAnSatr();
            }
            for (int i = 0; i < GamePanel.getGamePanel().gravityObject.size(); i++) {
                Gravity gr = GamePanel.getGamePanel().gravityObject.get(i);
                gr.Gravity(SpeedOfBrickP);
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
        for (int i=0 ; i <GamePanel.getGamePanel().brickArrayList.size();i++) {
            Brick br =GamePanel.getGamePanel().brickArrayList.get(i);
            if (br.getY() + br.getHeight() > 500) {
                HP -= 1;
                if (HP < 1) {
                    IsGameRunning = false;
                } else {
                    GamePanel.getGamePanel().remove(br);
                    GamePanel.getGamePanel().brickArrayList.remove(br);
                    GamePanel.getGamePanel().gravityObject.remove(br);
                    i--;
                }
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
            new CreatBrick(GamePanel.NUMBEROFBRICKINEACHSATR, CurrentValue, GamePanel.getGamePanel()).CustomCreat();
            if (!IS_IT_REV) {
                MoveDownOneStep(GamePanel.NUMBEROFBRICKINEACHSATR);
            } else {
                moveRev(GamePanel.NUMBEROFBRICKINEACHSATR);
                IS_IT_REV = false;
            }
            for (int i = 0; i < NUMBER_OF_BALL_TO_IN_THIS_ROUND; i++) {
                new Ball(GamePanel.StartX, GamePanel.startY, 15, 15, GamePanel.getGamePanel().ballPAth);
            }
            NUMBER_OF_BALL_TO_IN_THIS_ROUND = 1;
        }
    }
}