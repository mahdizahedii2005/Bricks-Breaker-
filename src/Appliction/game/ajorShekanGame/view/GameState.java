package Appliction.game.ajorShekanGame.view;

import Appliction.LogInState.Setting.setting;
import Appliction.game.ajorShekanGame.view.model.ObjectsInGame;
import Appliction.view.GameFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

public class GameState extends JPanel {
    boolean mamad = false;
    public static boolean IS_IT_SARGIJEH = false;
    private int ballBSpeed = 10;
    public static boolean isGameStop = false;
    private TimeHandeler timeHandeler;
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
    public static String path = "Pic\\images (1).jfif";
    private BufferedImage backgroundImage;
    private String PlayerName;
    private ScoreHandeler scoreHandeler;
    private ShowScore scoreShow;
    private ShowBestScore bestScoreShow;

    public GameState(String level, String Path, String PlayerName) {
        super();
        timeHandeler = new TimeHandeler();
        scoreHandeler = new ScoreHandeler(timeHandeler);
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
        add(new showTimeFrame(timeHandeler, this));
        gamePanel = new GamePanel(level, Path, scoreHandeler, PlayerName);
        add(gamePanel);
        gamePanel.addMouseListener(new MouseListener() {
            //  boolean isItClick = false;

            @Override
            public void mouseClicked(MouseEvent e) {
                if (!setting.Aim) {
                    if (!gamePanel.gameLoop.isBallTrow && !isGameStop && e.getY() < GamePanel.YFIRSTPLACOFBALL - 20) {
                        float xvel, yval = 6;
                        if (!IS_IT_SARGIJEH) {
                            float z = (float) (e.getX() + 5 - gamePanel.ballArrayList.get(0).getX()) / (e.getY() + 5 - gamePanel.ballArrayList.get(0).getY());
                            yval = (float) (Math.sqrt(ballBSpeed * ballBSpeed / (1 + (z * z))));
                            xvel = (float) (Math.sqrt((ballBSpeed * ballBSpeed) - (yval * yval)));
                        } else {
                            IS_IT_SARGIJEH = false;
                            yval = (float) new Random().nextInt(5) + 3;
                            xvel = (float) Math.sqrt((ballBSpeed * ballBSpeed) - (yval * yval));
                            if (new Random().nextInt(2) == 1) {
                                xvel = xvel * (-1);
                            }
                        }
                        if (e.getX() + 5 < gamePanel.ballArrayList.get(0).getX()) {
                            xvel = -1 * xvel;
                        }
                        gamePanel.ballArrayList.get(0).setxVal(xvel);
                        gamePanel.ballArrayList.get(0).setyVal(-1 * yval);
                        for (int j = 0; j < GamePanel.getGamePanel().ballArrayList.size(); j++) {
                            GamePanel.getGamePanel().ballArrayList.get(j).IsMoving = true;
                        }
                        gamePanel.gameLoop.isBallTrow = true;
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (setting.Aim) {
                    //       System.out.println("start");
                    handle(e.getX(), e.getY());
                    gamePanel.isItClick = true;
                    if (!gamePanel.gameLoop.isBallTrow && !isGameStop && e.getY() < GamePanel.YFIRSTPLACOFBALL - 20) {
                        mamad = true;
                    }
                }

                //  many = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //many = false;
                if (setting.Aim) {
                    mamad = false;
                    if (!gamePanel.gameLoop.isBallTrow && !isGameStop && e.getY() < GamePanel.YFIRSTPLACOFBALL - 20) {
                        //     System.out.println("finish");
                        float xvel, yval = 6;
                        if (!IS_IT_SARGIJEH) {
                            float z = (float) (e.getX() + 5 - gamePanel.ballArrayList.get(0).getX()) / (e.getY() + 5 - gamePanel.ballArrayList.get(0).getY());
                            yval = (float) (Math.sqrt(ballBSpeed * ballBSpeed / (1 + (z * z))));
                            xvel = (float) (Math.sqrt((ballBSpeed * ballBSpeed) - (yval * yval)));
                        } else {
                            IS_IT_SARGIJEH = false;
                            yval = (float) new Random().nextInt(5) + 3;
                            xvel = (float) Math.sqrt((ballBSpeed * ballBSpeed) - (yval * yval));
                            if (new Random().nextInt(2) == 1) {
                                xvel = xvel * (-1);
                            }
                        }
                        if (e.getX() + 5 < gamePanel.ballArrayList.get(0).getX()) {
                            xvel = -1 * xvel;
                        }
                        gamePanel.ballArrayList.get(0).setxVal(xvel);
                        gamePanel.ballArrayList.get(0).setyVal(-1 * yval);
                        for (int j = 0; j < GamePanel.getGamePanel().ballArrayList.size(); j++) {
                            GamePanel.getGamePanel().ballArrayList.get(j).IsMoving = true;
                        }
                        gamePanel.gameLoop.isBallTrow = true;
                        gamePanel.isItClick = false;
                        gamePanel.draw = false;
                        // System.out.println(GamePanel.getGamePanel().draw);
                    }
                    GamePanel.getGamePanel().repaint();
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        gamePanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (mamad) {
                    //    System.out.println("hi");
                    if (setting.Aim) {
                        //   System.out.println("start");
                        handle(e.getX(), e.getY());
                        gamePanel.isItClick = true;
                    }
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });
        CreatPusee();

        CreatExit();

        CreatJLabel(record, 1, 0, 200, 26, "Pic\\game pic\\yourRecord.png");

        CreatJLabel(bestRecord, 1, 35, 200, 22, "Pic\\game pic\\Best record.png");

        CreatJLabel(Time, 88, 67, 111, 30, "Pic\\game pic\\Time.png");

        scoreShow = new

                ShowScore(this);

        bestScoreShow = new

                ShowBestScore(this);
        GameFrame.getGameFrame().

                getMainPanel().

                add(this);

    }

    public void UpdateTheScore() {
        scoreShow.repaint();
        bestScoreShow.repaint();
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
                GamePanel.getGamePanel().musicPlayer.Stop();
                GamePanel.getGamePanel().musicPlayer.close();
                if (GamePanel.getGamePanel().gameLoop.IsGameRunning) {
                    gameFileProcese.WriteFile(GamePanel.getGamePanel().getPersonName(), GamePanel.getGamePanel().getScoreHandeler().getCurrentScore().toString(), LocalDate.now().toString(), LocalTime.now().toString());
                }
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
                    GamePanel.getGamePanel().musicPlayer.play();

                    timeHandeler.ReasumTheGame();
                } else {
                    GamePanel.getGamePanel().musicPlayer.Stop();
                    timeHandeler.PuseTheGame();
                }
                isGameStop = !isGameStop;
                GamePanel.getGamePanel().gameLoop.IsGamePus = isGameStop;
                revalidate();
                repaint();
            }
        });
    }

    private void handle(float x, float y) {
        float z = (x + 5 - GamePanel.getGamePanel().ballArrayList.get(0).getX()) / (y + 5 - GamePanel.getGamePanel().ballArrayList.get(0).getY());
        float yval, xvel;
        yval = (float) (-1 * (Math.sqrt(10 * 10 / (1 + (z * z)))));
        xvel = (float) (Math.sqrt((10 * 10) - (yval * yval)));
        if (x + 1 < GamePanel.getGamePanel().ballArrayList.get(0).getX()) {
            xvel = -1 * xvel;
        }
        int xball = GamePanel.getGamePanel().ballArrayList.get(0).getX(), yball = GamePanel.getGamePanel().ballArrayList.get(0).getY();
        while (xball < 491 && yball < 491 && xball > 10 && yball > 10 && !isItClickTouch(xball, yball)) {
            xball += xvel;
            yball += yval;
        }
        GamePanel.getGamePanel().finishx = Math.round(xball);
        GamePanel.getGamePanel().finishy = Math.round(yball);
        GamePanel.getGamePanel().draw = true;
        GamePanel.getGamePanel().repaint();
    }

    public ScoreHandeler getScoreHandeler() {
        return scoreHandeler;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(backgroundImage, 50, 190, 500, 500, null);
        super.paint(g);
    }

    private boolean isItClickTouch(float x, float y) {
        ObjectsInGame[] bricks = new ObjectsInGame[2000];
        for (int k = 0; k < GamePanel.getGamePanel().gravityObject.size(); k++) {
            ObjectsInGame br = (ObjectsInGame) GamePanel.getGamePanel().gravityObject.get(k);
            int a = (int) Math.sqrt(((x - br.getCenterX()) * (x - br.getCenterX())) + ((y - br.getCenterY()) * (y - br.getCenterY())));
            if (bricks[a] == null) {
                bricks[a] = br;
            } else {
                int j = 1;
                while (a < 500 && a > -1) {
                    a += j;
                    if (bricks[a] == null) {
                        bricks[a] = br;
                        break;
                    }
                    j++;
                    a -= j;
                    if (bricks[a] == null) {
                        bricks[a] = br;
                        break;
                    }
                    j++;
                }
            }
        }
        ObjectsInGame[] newb = new ObjectsInGame[10];
        int j = 0;
        for (int i = 0; i < 200 && j < 10; i++) {
            if (bricks[i] != null) {
                newb[j] = bricks[i];
                j++;
            }
        }
        for (int i = 0; i < newb.length; i++) {
            ObjectsInGame br = newb[i];
            if (br != null) {
                if (x < br.getX() + br.getWidth() && x > br.getX() && y < br.getY() + br.getHeight() && y > br.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean many = true;
}
