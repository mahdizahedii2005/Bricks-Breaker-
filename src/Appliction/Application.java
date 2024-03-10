package Appliction;

import Appliction.LogInState.LoginPAnnel;
import Appliction.view.GameFrame;

import javax.swing.*;

public class Application implements Runnable {
    public static GameFrame gameFrame;
    @Override
    public void run() {
        gameFrame = new GameFrame();

    }
}
