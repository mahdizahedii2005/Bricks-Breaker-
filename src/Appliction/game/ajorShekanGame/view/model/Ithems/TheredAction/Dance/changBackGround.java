package Appliction.game.ajorShekanGame.view.model.Ithems.TheredAction.Dance;

import Appliction.LogInState.background;
import Appliction.game.ajorShekanGame.view.GameState;
import Appliction.game.ajorShekanGame.view.model.Ball;
import Appliction.view.GameFrame;

public class changBackGround extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                if (Ball.ballphoto.equals("Pic\\ball\\sherek 5\\sherek 5.png")) {
                    background.path = "Pic\\sherek.png";
                } else {
                    background.path = "Pic\\background.png";
                }
            } else {
                background.path = "Pic\\black-.jpg";
            }
            background.getBackgrand().setBackgroundImage();
            GameFrame.getGameFrame().revalidate();
            GameFrame.getGameFrame().repaint();
            while (GameState.isGameStop){}
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
