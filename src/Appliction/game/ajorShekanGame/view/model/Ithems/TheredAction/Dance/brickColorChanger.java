package Appliction.game.ajorShekanGame.view.model.Ithems.TheredAction.Dance;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.GameState;
import Appliction.game.ajorShekanGame.view.model.Brick;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

import static Appliction.game.ajorShekanGame.view.model.CreatBrick.*;

public class brickColorChanger extends Thread {
    ArrayList<Brick> invisibleBrick = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i < 40; i++) {
            if (i % 3 == 0) {
                for (Brick br : invisibleBrick) {
                    br.setVisible(true);
                }
                invisibleBrick = new ArrayList<>();
            }
            for (int j = 0; GamePanel.getGamePanel().brickArrayList.size() > j; j++) {
                Brick br = GamePanel.getGamePanel().brickArrayList.get(j);
                if (!br.isItSpe()) {
                    if (new Random().nextInt(16) == 14) {
                        br.setVisible(false);
                        invisibleBrick.add(br);
                    } else {
                        String path = br.getPath();
                        Random random = new Random();
                        while (path.equals(br.getPath())) {
                            if (GamePanel.level.equals("hard")) {
                                path = ColorBrickHard.get(random.nextInt(ColorBrickHard.size()));
                            } else if (GamePanel.level.equals("normal")) {
                                path = ColorBrickNormal.get(random.nextInt(ColorBrickHard.size()));
                            } else if (GamePanel.level.equals("ez")) {
                                System.out.println(ColorBrickEz.size());
                                path = ColorBrickEz.get(random.nextInt(ColorBrickEz.size()));
                            }
                        }
                        br.setIcon(new ImageIcon(path));
                    }
                }
            }
            GamePanel.getGamePanel().repaint();
            while (GameState.isGameStop) {
            }
            try {
                sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (Brick br : invisibleBrick) {
            br.setVisible(true);
        }
        invisibleBrick = new ArrayList<>();
        GamePanel.getGamePanel().repaint();
    }
}
