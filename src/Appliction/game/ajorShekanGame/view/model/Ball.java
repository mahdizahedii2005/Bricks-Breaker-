package Appliction.game.ajorShekanGame.view.model;

import Appliction.game.ajorShekanGame.view.GamePanel;

import javax.swing.*;

public class Ball extends ObjectsInGame implements IMoveable {
    private int xVal;
    private int yVal;

    public Ball(int x, int y, int width, int height, String Path) {
        super(x, y, width, height);
        setBounds(x, y, width, height);
        setIcon(new ImageIcon(Path));
        setVisible(true);
        setOpaque(true);
        GamePanel.getGamePanel().add(this);
        GamePanel.getGamePanel().ballArrayList.add(this);
    }

    @Override
    public void Move() {
        setX(getX() + getxVal());
        setY(getY() + getyVal());
        setBounds(getX(), getY(), getWidth(), getHeight());
        repaint();
    }

    public int getxVal() {
        return xVal;
    }

    public void setxVal(int xVal) {
        this.xVal = xVal;
    }

    public int getyVal() {
        return yVal;
    }

    public void setyVal(int yVal) {
        this.yVal = yVal;
    }
}
