package Appliction.game.ajorShekanGame.view;

import Appliction.game.ajorShekanGame.gameMusicPlayer;
import Appliction.game.ajorShekanGame.view.Controler.gameLoop;
import Appliction.game.ajorShekanGame.view.model.Ball;
import Appliction.game.ajorShekanGame.view.model.Brick;
import Appliction.game.ajorShekanGame.view.model.Gravity;
import Appliction.game.ajorShekanGame.view.model.Ithems.Item;
import Appliction.game.ajorShekanGame.view.model.ObjectsInGame;

import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public static boolean Hp = true;
    public static int NUMBEROFBRICKINEACHSATR = 5;
    public static int StartX = -1;
    public static int startY = 484;
    public static final int XFIRSTPLACOFBALL = 250;
    public static final int YFIRSTPLACOFBALL = 484;
    public static String level, ballPAth;
    private static GamePanel gamePanel;
    public ArrayList<ObjectsInGame> firstBrick = new ArrayList<>();
    public ArrayList<Brick> brickArrayList = new ArrayList<>();
    public ArrayList<Ball> ballArrayList = new ArrayList<>();
    public ArrayList<Item> ItemArrayList = new ArrayList<>();
    public ArrayList<Gravity> gravityObject = new ArrayList<>();
    public gameLoop gameLoop;
    public static final int MaxWidth = 500;
    public static final int MaxHeight = 500;
    public static final int BallLength = 15;
    public static gameMusicPlayer musicPlayer=new gameMusicPlayer("Pic\\song\\gta.wav");;

    public GamePanel(String level, String BallPath) {
        super();
        musicPlayer.play();
        this.level = level;
        if (level.equals("hard")) {
            NUMBEROFBRICKINEACHSATR = 10;
        } else if (level.equals("normal")) {
            NUMBEROFBRICKINEACHSATR = 5;
        } else if (level.equals("ez")) {
            NUMBEROFBRICKINEACHSATR = 4;
        }
        this.ballPAth = BallPath;
        setBounds(50, 190, 500, 500);
        setOpaque(false);
        setLayout(null);
        setFocusable(true);
        requestFocus();
        requestFocusInWindow();
        gamePanel = this;
        new Ball(XFIRSTPLACOFBALL, YFIRSTPLACOFBALL, BallLength, BallLength, ballPAth);
        gameLoop = new gameLoop();
        gameLoop.start();
    }

    public ArrayList<ObjectsInGame> getFirstBrick() {
        return firstBrick;
    }

    public ArrayList<Brick> getBrickArrayList() {
        return brickArrayList;
    }

    public ArrayList<Ball> getBallArrayList() {
        return ballArrayList;
    }

    public static GamePanel getGamePanel() {
        if (gamePanel == null) {
            gamePanel = new GamePanel(gamePanel.level, gamePanel.ballPAth);
        }
        return gamePanel;
    }
}
