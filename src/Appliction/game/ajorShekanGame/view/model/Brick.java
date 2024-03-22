package Appliction.game.ajorShekanGame.view.model;

import Appliction.game.ajorShekanGame.view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Brick extends ObjectsInGame implements Gravity {

    private String Path;
    Integer value;

    public Brick(int x, int y, int width, int height, Integer value, String Path) {
        super(x, y, width, height);
        this.value = value;
        this.Path = Path;
        setFont(new Font("Arial", Font.ITALIC, 17));
        setIcon(new ImageIcon(Path));
        setText(value.toString());
        setHorizontalTextPosition(JLabel.CENTER);
    }

    public void DicreasValue() {
        this.value -= 1;
        setText(value.toString());
        if (value <= 0) {
            GamePanel.getGamePanel().gravityObject.remove(this);
            GamePanel.getGamePanel().brickArrayList.remove(this);
            GamePanel.getGamePanel().remove(this);
            // TODO: ۲۰/۰۳/۲۰۲۴ Score
            GamePanel.getGamePanel().repaint();
            return;
        }
        String a = CreatBrick.ColorBrick.get(new Random().nextInt(CreatBrick.ColorBrick.size()));
        while (a.equals(Path)) {
            a = CreatBrick.ColorBrick.get(new Random().nextInt(CreatBrick.ColorBrick.size()));
        }
        setIcon(new ImageIcon(a));
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
}
