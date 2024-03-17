package Appliction.game.ajorShekanGame.view.model;

import javax.swing.*;
import java.awt.*;

public class Brick extends ObjectsInGame implements Gravity {

    int value;
    public Brick(int x, int y, int width, int height,Integer value , String Path) {
        super(x, y, width, height);
        this.value = value;
        setFont(new Font("Arial", Font.ITALIC, 17));
        setIcon(new ImageIcon(Path));
        setText(value.toString());
        setHorizontalTextPosition(JLabel.CENTER);
    }

    public int getValue() {
        return value;
    }

    @Override
    public void Gravity() {
        setY(getY()+10);
        setBounds(getX(),getY(),getWidth(),getWidth());
    }
}
