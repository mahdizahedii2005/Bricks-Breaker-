package Appliction.game.ajorShekanGame.view;

import Appliction.view.GameFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameState extends JPanel {
    public static boolean isGameStop = false;
    TimeHandeler timeHandeler;
    String level, ballPath, PlayerName;
    private showTimeFrame timeShow;
    private JLabel recordShow;
    private JLabel bestRecordShow;
    private GamePanel gamePanel;
    private JButton Exit;
    private JButton Puse;
    private JLabel record;
    private JLabel Time;
    private JLabel bestRecord;
    public static int PersonRecord = 0;
    public static int BestRecord = 0;// TODO: ۱۴/۰۳/۲۰۲۴  fix best record
    private String path = "Pic\\images (1).jfif";
    private BufferedImage backgroundImage;

    public GameState() {
        super();
        setBounds(0, 0, 600, 800);
        setOpaque(false);
        setLayout(null);
        setVisible(true);
        try {
            backgroundImage = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        timeHandeler = new TimeHandeler();
        add(new showTimeFrame(timeHandeler, this));
        gamePanel = new GamePanel();
        add(gamePanel);
        CreatPusee();
        CreatExit();
        CreatJLabel(record, 1, 0, 200, 26, "Pic\\game pic\\yourRecord.png");
        CreatJLabel(bestRecord, 1, 35, 200, 22, "Pic\\game pic\\Best record.png");
        CreatJLabel(Time, 88, 67, 111, 30, "Pic\\game pic\\Time.png");
        GameFrame.getGameFrame().getMainPanel().add(this);
    }

    private void CreatJButton(JButton jbutton, int x, int y, int width, int height) {
        jbutton.setBounds(x, y, width, height);
        jbutton.setVisible(true);
        jbutton.setOpaque(true);
        add(jbutton);
    }

    private void CreatJLabel(JLabel jLabel, int x, int y, int width, int height, String path) {
        jLabel = new JLabel(new ImageIcon(path));
        jLabel.setBounds(x, y, width, height);
        jLabel.setOpaque(true);
        jLabel.setVisible(true);
        add(jLabel);
    }

    private void CreatExit() {
        Exit = new JButton(new ImageIcon("Pic\\game pic\\EXET.png"));
        CreatJButton(Exit, 200, 700, 190, 30);
        Exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: ۱۴/۰۳/۲۰۲۴ Finish the game
                GameFrame.getGameFrame().newStage();
                new Appliction.LogInState.LoginPAnnel(GameFrame.getGameFrame().getMainPanel());
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().repaint();
            }
        });
        add(Exit);
    }

    private void CreatPusee() {
        Puse = new JButton(new ImageIcon("Pic\\game pic\\puese.png"));
        CreatJButton(Puse, 535, 2, 40, 40);
        Puse.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isGameStop) {
                    timeHandeler.ReasumTheGame();
                } else {
                    timeHandeler.PuseTheGame();
                }
                isGameStop = !isGameStop;
                GamePanel.getGamePanel().gameLoop.IsGamePus=isGameStop;
                revalidate();
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(backgroundImage, 50, 190, 500, 500, null);
        super.paint(g);
    }
}
