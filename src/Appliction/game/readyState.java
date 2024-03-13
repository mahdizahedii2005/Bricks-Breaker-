package Appliction.game;

import Appliction.view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class readyState {
    private JButton back;
    private JButton letRoll;
    private String personName = "";
    private JTextField nameFiled;
    private JLabel EnterName;
    private JButton sherek;
    private JButton Sceleton1;
    private JButton Sceleton2;
    private JButton blue;
    private JButton red;
    private JButton lightBlue;
    private JButton green;
    private JButton Brown;
    private final int HLevel = 150;
    private JLabel choseball;
    private JPanel readyState;
    private JLabel Level;
    private JButton ez;
    private JButton normal;
    private JButton hard;
    private JLabel readyForGame;
    private final String RH = "Pic\\RHard.png";
    private final String WH = "Pic\\W-H.png";
    private final String WN = "Pic\\WNormal.png";
    private final String GN = "Pic\\Gnormal.png";
    private final String WE = "Pic\\Weasy.png";
    private final String BE = "Pic\\Bez.png";
    private String CurrentH = WH;
    private String CurrentN = WN;
    private String CurrentE = BE;
    public static final String sherekBall = "Pic\\ball\\sherek 5.jfif";
    public static final String Sckeleton1 = "Pic\\ball\\Skelleton2.png";
    public static final String Sckeleton2 = "Pic\\ball\\images (1).png";
    public static final String lightBlueBall = "Pic\\ball\\blue-circle-icon-18.png";
    public static final String redBall = "Pic\\ball\\red-circle-icon-16.png";
    public static final String GreenBall = "Pic\\ball\\green.png";
    public static final String brownBall = "Pic\\ball\\botonrojooscuro-th.png";
    public static final String BlueBall = "Pic\\ball\\blue.png";

    public readyState(JPanel mainPanel) {
        CreatReadyStatePanel();
        CreatReadyState();
        mainPanel.add(readyState);

    }

    public void CreatReadyStatePanel() {
        readyState = new JPanel();
        readyState.setBounds(0, 0, 600, 800);
        readyState.setFocusable(true);
        readyState.requestFocus();
        readyState.requestFocusInWindow();
        readyState.setLayout(null);
        readyState.setOpaque(false);
    }

    private void CreatReadyState() {
        CreatJLabel(Level, 10, HLevel, 127, 35, "Pic\\Level.png");
        CreatJLabel(readyForGame, 129, 5, 342, 30, "Pic\\getReady.png");
        Createz();
        CreatHard();
        CreatNormal();
        CreatJLabel(choseball, 150, 300, 300, 35, "Pic\\Chooseball.png");
        CreatBallSett();
        CreatJLabel(EnterName, 20, 470, 271, 30, "Pic\\nameinput.png");
        CreatNameInput();
        LetsRoll();
        CreatBack();
    }
    private void CreatBack(){
        back = new JButton(new ImageIcon("Pic\\backk.png"));
        CreatJbutton(back,0,0,40,40);
        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame.getGameFrame().newStage();
                new Appliction.LogInState.LoginPAnnel(GameFrame.getGameFrame().getMainPanel());
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().repaint();
            }
        });
        readyState.add(back);
    }

    private void CreatNameInput() {
        nameFiled = new JTextField();
        nameFiled.setBounds(300, 470, 250, 30);
        nameFiled.setVisible(true);
        nameFiled.setOpaque(true);
        nameFiled.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personName = nameFiled.getText();
                System.out.println(personName);
            }
        });
        readyState.add(nameFiled);
    }

    private void LetsRoll(){
        letRoll = new JButton(new ImageIcon("Pic\\letsroll.png"));
        CreatJbutton(letRoll,175,600,258,40);
        letRoll.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        readyState.add(letRoll);
    }

    private void CreatJLabel(JLabel jLabel, int x, int y, int width, int height, String path) {
        jLabel = new JLabel(new ImageIcon(path));
        jLabel.setBounds(x, y, width, height);
        jLabel.setVisible(true);
        jLabel.setOpaque(true);
        readyState.add(jLabel);
    }

    private void CreatJbutton(JButton jButton, int x, int y, int width, int height) {
        jButton.setBounds(x, y, width, height);
        jButton.setVisible(true);
        jButton.setOpaque(true);
    }

    private void CreatHard() {
        hard = new JButton(new ImageIcon(CurrentH));
        CreatJbutton(hard, 142, HLevel, 128, 35);
        hard.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CurrentH.equals(WH)) {
                    CurrentH = RH;
                    CurrentN = WN;
                    CurrentE = WE;
                    readyState.remove(hard);
                    readyState.remove(normal);
                    readyState.remove(ez);
                    CreatHard();
                    Createz();
                    CreatNormal();
                    GameFrame.getGameFrame().repaint();
                }
            }
        });
        readyState.add(hard);
    }

    private void CreatNormal() {
        normal = new JButton(new ImageIcon(CurrentN));
        CreatJbutton(normal, 275, HLevel, 190, 35);
        normal.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CurrentN.equals(WN)) {
                    CurrentH = WH;
                    CurrentN = GN;
                    CurrentE = WE;
                    readyState.remove(hard);
                    readyState.remove(normal);
                    readyState.remove(ez);
                    CreatHard();
                    Createz();
                    CreatNormal();
                    GameFrame.getGameFrame().repaint();

                }
            }
        });
        readyState.add(normal);
    }

    private void Createz() {
        ez = new JButton(new ImageIcon(CurrentE));
        CreatJbutton(ez, 470, HLevel, 114, 35);
        ez.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CurrentE.equals(WE)) {
                    CurrentH = WH;
                    CurrentN = WN;
                    CurrentE = BE;
                    readyState.remove(hard);
                    readyState.remove(normal);
                    readyState.remove(ez);
                    CreatHard();
                    Createz();
                    CreatNormal();
                    GameFrame.getGameFrame().repaint();

                }
            }
        });
        readyState.add(ez);

    }

    private void CreatBallSett() {
        CreatSherek();
        CreatSceleton1();
        CreatRed();
        CreatSceleton2();
        CreatBrown();
        CreatBlue();
        CreatLigthBlue();
        CreatGreen();
    }

    private void CreatSherek() {
        sherek = new JButton(new ImageIcon(sherekBall));
        CreatJbutton(sherek, 62, 300, 35, 35);
        sherek.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        readyState.add(sherek);
    }

    private void CreatSceleton1() {
        Sceleton1 = new JButton(new ImageIcon(Sckeleton1));
        CreatJbutton(Sceleton1, 172, 250, 35, 35);
        readyState.add(Sceleton1);
    }

    //        CreatJLabel(choseball, 150, 300, 300, 35, "Pic\\Chooseball.png");
    private void CreatRed() {
        red = new JButton(new ImageIcon(redBall));
        CreatJbutton(red, 172, 355, 35, 35);
        readyState.add(red);
    }

    private void CreatSceleton2() {
        Sceleton2 = new JButton(new ImageIcon(Sckeleton2));
        CreatJbutton(Sceleton2, 400, 250, 35, 35);
        readyState.add(Sceleton2);
    }

    private void CreatBrown() {
        Brown = new JButton(new ImageIcon(brownBall));
        CreatJbutton(Brown, 287, 250, 35, 35);
        readyState.add(Brown);
    }

    private void CreatBlue() {
        blue = new JButton(new ImageIcon(BlueBall));
        CreatJbutton(blue, 287, 355, 35, 35);
        readyState.add(blue);
    }

    private void CreatLigthBlue() {
        lightBlue = new JButton(new ImageIcon(lightBlueBall));
        CreatJbutton(lightBlue, 475, 300, 35, 35);
        readyState.add(lightBlue);
    }

    private void CreatGreen() {
        green = new JButton(new ImageIcon(GreenBall));
        CreatJbutton(green, 400, 355, 35, 35);
        readyState.add(green);
    }
}
