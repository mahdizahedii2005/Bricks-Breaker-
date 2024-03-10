package Appliction.LogInState;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class background extends JPanel {
    private static background background;
    private String path = "Pic\\black-.jpg";
    private BufferedImage backgroundImage;

    public background() {
        try {
            backgroundImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setBounds(0, 0, 600, 800);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, 600, 800, null);
        }
    }

    public static background getBackgrand() {
        if (background == null) {
            background = new background();
        }
        return background;
    }
}
