package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.gameMusicPlayer;
import Appliction.game.ajorShekanGame.view.GamePanel;

import javax.swing.*;

public class boom extends Thread {
    int x, y;
    String Path;
    JLabel boom;

    public boom(int x, int y) {
        this.x = x;
        this.y = y;
        boom = new JLabel();
        if (GamePanel.level.equals("hard")) {
            boom.setIcon(new ImageIcon("Pic\\Item\\Hard\\explo.png"));
            boom.setBounds(x - 75, y - 75, 150, 150);
        } else if (GamePanel.level.equals("normal")) {
            boom.setIcon(new ImageIcon("Pic\\Item\\Normal\\explo.png"));
            boom.setBounds(x - 150, y - 150, 300, 300);
        } else if (GamePanel.level.equals("ez")) {
            boom.setIcon(new ImageIcon("Pic\\Item\\Easy\\explo.png"));
            boom.setBounds(x - 187, y - 187, 374, 374);
        }
        boom.setVisible(true);
        boom.setOpaque(true);
    }

    @Override
    public void run() {
        new gameMusicPlayer("Pic\\song\\bom.wav").play();
        GamePanel.getGamePanel().add(boom);
        GamePanel.getGamePanel().repaint();
        try {
            sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GamePanel.getGamePanel().remove(boom);
        GamePanel.getGamePanel().repaint();

    }
}
