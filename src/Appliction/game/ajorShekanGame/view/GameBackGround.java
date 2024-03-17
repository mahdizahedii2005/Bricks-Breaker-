package Appliction.game.ajorShekanGame.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameBackGround extends JPanel {
    private static GameBackGround gameBackGround;
    private String path ="Pic\\images (1).jfif";
    private BufferedImage backgroundImage;

    public GameBackGround() {
        try {
            backgroundImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setBounds(0, 0, 500, 500);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 500, 500, null);
        }
    }

    public static GameBackGround getGameBackgrand() {
        if (gameBackGround == null) {
            gameBackGround = new GameBackGround();
        }
        return gameBackGround;
    }

}
