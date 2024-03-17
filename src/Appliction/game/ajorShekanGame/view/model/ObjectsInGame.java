package Appliction.game.ajorShekanGame.view.model;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class ObjectsInGame extends JLabel {
    private int x;
    private int y;
    private int width;
    private int height;

    protected BufferedImage background;

    public ObjectsInGame(int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        setVisible(true);
        setOpaque(true);
        setBounds(x, y, width, height);
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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


