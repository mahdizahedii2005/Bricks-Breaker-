package Appliction.game.ajorShekanGame.view.model.Ithems.TheredAction;

import Appliction.game.ajorShekanGame.gameMusicPlayer;
import Appliction.game.ajorShekanGame.view.GamePanel;

import javax.swing.*;

public class Bomb extends Thread {
    int x, y;
    gameMusicPlayer a ;
    public Bomb(int x, int y,gameMusicPlayer a) {
        this.a=a;
        this.x = x;
        this.y = y;
    }
    @Override
    public void run() {
        JLabel boom = new JLabel();
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
        new gameMusicPlayer("Pic\\song\\bom.wav").play();
        GamePanel.getGamePanel().add(boom);
        GamePanel.getGamePanel().repaint();
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        a.close();
        GamePanel.getGamePanel().remove(boom);
        GamePanel.getGamePanel().repaint();
    }
}
