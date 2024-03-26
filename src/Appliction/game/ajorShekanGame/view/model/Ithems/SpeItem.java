package Appliction.game.ajorShekanGame.view.model.Ithems;

import javax.swing.*;
import java.awt.*;

public abstract class SpeItem extends Item {
    Integer valur;

    public SpeItem(int x, int y, Integer value) {
        super(x, y);
        valur = value;
        setForeground(Color.RED);
        setFont(new Font("Arial", Font.ITALIC, 17));
        setText(value.toString());
        setHorizontalTextPosition(JLabel.CENTER);
    }

    public void kamshodam(Integer a) {
        setFont(new Font("Arial", Font.ITALIC, 17));
        setText(a.toString());
        setHorizontalTextPosition(JLabel.CENTER);
    }
}
