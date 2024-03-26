package Appliction.game.ajorShekanGame.view;

import javax.swing.*;
import java.awt.*;

public class ShowScore extends JLabel {
    GameState gameState;

    public ShowScore(GameState jPanel) {
        gameState = jPanel;
        setBounds(207, 0, 70, 26);
        setVisible(true);
        setOpaque(true);
        setText(gameState.getScoreHandeler().getCurrentScore().toString());
        setFont(new Font("Arial", Font.ITALIC, 17));
        gameState.add(this);
    }
    public void update() {
        setText(gameState.getScoreHandeler().getCurrentScore().toString());
    }
    @Override
    public void paint(Graphics g) {
        update();
        super.paint(g);
    }
}
