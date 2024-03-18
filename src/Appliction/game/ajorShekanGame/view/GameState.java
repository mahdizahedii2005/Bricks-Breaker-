package Appliction.game.ajorShekanGame.view;

import Appliction.view.GameFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameState extends JPanel {
    int ballBSpeed =29;
    public static boolean isGameStop = false;
    TimeHandeler timeHandeler;
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
    private String PlayerName;

    public GameState(String level, String Path, String PlayerName) {
        super();
        this.PlayerName = PlayerName;
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
        gamePanel = new GamePanel(level, Path);
        add(gamePanel);
        gamePanel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("hi");
                int xvel ,yval;
                Double z =(double)(e.getX()-GamePanel.XFIRSTPLACOFBALL)/(e.getY()-GamePanel.YFIRSTPLACOFBALL);
                yval = (int)Math.sqrt(ballBSpeed*ballBSpeed/(1+(z*z)));
                xvel = (int)Math.sqrt((ballBSpeed*ballBSpeed)-(yval*yval));
                if (e.getX()<GamePanel.XFIRSTPLACOFBALL){
                    xvel = -1*xvel;
                }
                gamePanel.ballArrayList.get(0).setxVal(1*xvel);
                gamePanel.ballArrayList.get(0).setyVal(-1*yval);
                gamePanel.gameLoop.isBallTrow=true;
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
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
                GamePanel.getGamePanel().gameLoop.IsGamePus = isGameStop;
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
