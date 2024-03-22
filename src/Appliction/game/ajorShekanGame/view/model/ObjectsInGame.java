package Appliction.game.ajorShekanGame.view.model;

import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class ObjectsInGame extends JLabel {
    protected float x;
    protected float y;
    private int width;
    private int height;

    protected BufferedImage background;

    public ObjectsInGame(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public ObjectsInGame(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = (float) x;
        this.y = (float) y;
        setVisible(true);
        setOpaque(true);
        setBounds(x, y, width, height);
    }

    @Override
    public int getX() {
        return Math.round(x);
    }

    public void setX(int x) {
        this.x = (float) x;
    }

    @Override
    public int getY() {
        return Math.round(y);
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCenterX() {
        return getX() + (getWidth() / 2);
    }

    public int getCenterY() {
        return getY() + (getHeight() / 2);
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


}


