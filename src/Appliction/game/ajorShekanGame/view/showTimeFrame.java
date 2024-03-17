package Appliction.game.ajorShekanGame.view;

import javax.swing.*;
import java.awt.*;

public class showTimeFrame extends JLabel {
    TimeHandeler timeHandeler;
    public showTimeFrame(TimeHandeler timeHandeler,JPanel jPanel) {
        super(timeHandeler.toString());
        this.timeHandeler = timeHandeler;
        setBounds(207, 67, 70, 30);
        setVisible(true);
        setOpaque(true);
        setFont(new Font("Arial", Font.ITALIC, 17));
        jPanel.add(this);
    }
    @Override
    public void paint(Graphics g) {
        setText(timeHandeler.toString());
        super.paint(g);
    }
}
