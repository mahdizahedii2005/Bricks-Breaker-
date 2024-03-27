package Appliction.game.ajorShekanGame.view;
import javax.swing.*;
import java.awt.*;

public class ShowBestScore extends JLabel {
    GameState gameState;

    public ShowBestScore(GameState gameState) {
        this.gameState = gameState;
        setBounds(207, 35, 70, 22);
        setVisible(true);
        setOpaque(true);
        setFont(new Font("Arial", Font.ITALIC, 17));
        gameState.add(this);
        // TODO: ۲۵/۰۳/۲۰۲۴
        setText(gameFileProcese.BestScore().toString());
    }
    public void update() {
        if (Integer.parseInt(getText()) < gameState.getScoreHandeler().getCurrentScore()) {
            setText(gameState.getScoreHandeler().getCurrentScore().toString());
        }
    }
    @Override
    public void paint(Graphics g) {
        update();
        super.paint(g);
    }
}
