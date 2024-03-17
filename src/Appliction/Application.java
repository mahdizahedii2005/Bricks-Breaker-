package Appliction;

import Appliction.view.GameFrame;
public class Application implements Runnable {
    public static GameFrame gameFrame;
    @Override
    public void run() {
        gameFrame = new GameFrame();
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gameFrame.repaint();
        }

    }
}
