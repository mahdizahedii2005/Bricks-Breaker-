package Appliction.game.ajorShekanGame.view;

import Appliction.game.ajorShekanGame.view.Controler.gameLoop;
import Appliction.game.ajorShekanGame.view.model.Ball;
import Appliction.game.ajorShekanGame.view.model.Brick;

import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private static GamePanel gamePanel;
    public ArrayList<Brick> firstBrick = new ArrayList<>();
    public ArrayList<Brick> brickArrayList = new ArrayList<>();
    public ArrayList<Ball> ballArrayList = new ArrayList<>();
public gameLoop gameLoop;
    public GamePanel() {
        super();
        setBounds(50, 190, 500, 500);
        setOpaque(false);
        setLayout(null);
        setFocusable(true);
        requestFocus();
        requestFocusInWindow();
        gamePanel = this;
        gameLoop = new gameLoop();
        gameLoop.start();
    }

    public ArrayList<Brick> getFirstBrick() {
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
            gamePanel = new GamePanel();
        }
        return gamePanel;
    }
}
