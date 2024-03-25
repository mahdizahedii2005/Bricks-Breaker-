package Appliction.game.ajorShekanGame.view.model;

import Appliction.game.ajorShekanGame.view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static Appliction.game.ajorShekanGame.view.model.CreatBrick.*;

public class Brick extends ObjectsInGame implements Gravity {
    public static int BALL_POWER = 1;
    private String Path;
    Integer value;

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Brick(int x, int y, int width, int height, Integer value, String Path) {
        super(x, y, width, height);
        this.value = value;
        this.Path = Path;
        setFont(new Font("Arial", Font.ITALIC, 17));
        setIcon(new ImageIcon(Path));
        setText(value.toString());
        setHorizontalTextPosition(JLabel.CENTER);

    }

    public static boolean Vallide(int x, int y, int width, int height) {
        for (Brick br : GamePanel.getGamePanel().brickArrayList) {
            if (x > br.getX() - width && x < br.getX() + br.getWidth() && y > br.getY() - height && y < br.getHeight() + br.getY()) {
                return false;
            }
        }
        return true;
    }

    public void Explosive() {
        value -= 50;
        if (value <= 0) {
            GamePanel.getGamePanel().gravityObject.remove(this);
            GamePanel.getGamePanel().brickArrayList.remove(this);
            GamePanel.getGamePanel().remove(this);
            // TODO: ۲۰/۰۳/۲۰۲۴ Score
        }
    }

    public void DicreasValue() {
        this.value -= BALL_POWER;
        setText(value.toString());
        if (value <= 0) {
            GamePanel.getGamePanel().gravityObject.remove(this);
            GamePanel.getGamePanel().brickArrayList.remove(this);
            GamePanel.getGamePanel().remove(this);
            // TODO: ۲۰/۰۳/۲۰۲۴ Score
            GamePanel.getGamePanel().repaint();
            return;
        }
        String path = Path;
        Random random = new Random();
        while (path.equals(Path)) {
            if (GamePanel.level.equals("hard")) {
                path = ColorBrickHard.get(random.nextInt(ColorBrickHard.size()));
            } else if (GamePanel.level.equals("normal")) {
                path = ColorBrickNormal.get(random.nextInt(ColorBrickHard.size()));
            } else if (GamePanel.level.equals("ez")) {
                System.out.println(ColorBrickEz.size());
                path = ColorBrickEz.get(random.nextInt(ColorBrickEz.size()));
            }
        }
        setIcon(new ImageIcon(path));
        repaint();
        // System.out.println("hi");
    }

    public int getValue() {
        return value;
    }

    @Override
    public void Gravity(int mizan) {
        setY(getY() + mizan);
        setBounds(getX(), getY(), getWidth(), getWidth());
    }

    @Override
    public String toString() {
        return getValue() + ", X:" + getCenterX() + ", Y:" + getCenterY();
    }
}
