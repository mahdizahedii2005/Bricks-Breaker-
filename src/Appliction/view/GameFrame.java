package Appliction.view;

import Appliction.LogInState.LoginPAnnel;
import Appliction.LogInState.background;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public static int MAXHEIGHT = 800;
    private static GameFrame gameFrame;
    public static int MAXWIDTH = 600;

    private JPanel panel;
    private JPanel mainPanel;
    private background background;

    public GameFrame() {
        gameFrame = this;
        CreatFrame();
        CreatPanel();
        CreatMainPanel();
        CreatLoginPanel();
        addBackGrand();
        repaint();
        JLabel mamd = new JLabel(new ImageIcon("D:\\Desktop\\kandid photo\\ball\\headsherekkk.png"));
        mamd.setBounds(0, 0, 25, 25);
        mamd.setVisible(true);
        mamd.setOpaque(true);
        mainPanel.add(mamd);
        this.repaint();
    }

    public void CreatFrame() {
        setTitle("ajor Sheckan");
        setSize(new Dimension(MAXWIDTH, MAXHEIGHT));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void CreatPanel() {
        panel = new JPanel();
        panel.setBounds(0, 0, 600, 800);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.setLayout(null);
        setContentPane(panel);
    }

    public void CreatMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBounds(0, 0, 600, 800);
        mainPanel.setFocusable(true);
        mainPanel.setOpaque(false);
        mainPanel.requestFocus();
        mainPanel.requestFocusInWindow();
        mainPanel.setLayout(null);
        panel.add(mainPanel);
    }

    public void CreatLoginPanel() {
        new LoginPAnnel(mainPanel);
    }

    public void addBackGrand() {
        panel.add(Appliction.LogInState.background.getBackgrand());
    }

    public static GameFrame getGameFrame() {
        if (gameFrame == null) {
            gameFrame = new GameFrame();
        }
        return gameFrame;
    }

    public void newStage() {
        CreatPanel();
        CreatMainPanel();
        repaint();
    }

    public static int getMAXHEIGHT() {
        return MAXHEIGHT;
    }

    public static void setMAXHEIGHT(int MAXHEIGHT) {
        GameFrame.MAXHEIGHT = MAXHEIGHT;
    }

    public static void setGameFrame(GameFrame gameFrame) {
        GameFrame.gameFrame = gameFrame;
    }

    public static int getMAXWIDTH() {
        return MAXWIDTH;
    }

    public static void setMAXWIDTH(int MAXWIDTH) {
        GameFrame.MAXWIDTH = MAXWIDTH;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setBackground(Appliction.LogInState.background background) {
        this.background = background;
    }
}
