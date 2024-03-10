package Appliction.view;

import Appliction.LogInState.LoginPAnnel;
import Appliction.LogInState.background;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public static int MAXHEIGHT = 800;

    public static int MAXWIDTH = 600;

    private JPanel gamePanel;
    private JPanel panel;

    private background background;
    private LoginPAnnel loginPAnnel;

    public GameFrame() {
        setTitle("ajor Sheckan");
        setSize(new Dimension(MAXWIDTH, MAXHEIGHT));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        panel = new JPanel();
        panel = new JPanel();
        panel.setBounds(0, 0, 600, 800);
        panel.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.setLayout(null);
        setContentPane(panel);
        background = new background();
        background.setLayout(null);
        panel.add(background);
        gamePanel = new JPanel();
        gamePanel.setBounds(0, 0, 600, 800);
        gamePanel.setVisible(true);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        gamePanel.requestFocusInWindow();
        gamePanel.setLayout(null);
        gamePanel.setOpaque(false);
        loginPAnnel = new LoginPAnnel(gamePanel);
        panel.add(gamePanel);
        repaint();
    }
}
