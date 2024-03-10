package Appliction.LogInState;

import Appliction.Application;
import javax.swing.*;
import java.awt.event.ActionEvent;
public class LoginPAnnel {
    protected JPanel gamePanel;
    private JPanel background;
    private JButton StartGame;
    private JButton records;
    private JButton History;
    private JButton setting;
    private JButton Exit;
    private final int startButton = 65;
    private final int Height = 71;
    private final int Width = 450;


    public LoginPAnnel(JPanel gamePanel) {
        this.gamePanel = gamePanel;
        this.background = Appliction.LogInState.background.getBackgrand();
        creatLogin();
        gamePanel.repaint();
    }

    public JPanel getBackground() {
        return background;
    }

    private void addExit() {
        Exit = new JButton("Exit");
        Exit.setBounds(startButton, startButton * 9, Width, Height);
        Exit.setVisible(true);
        Exit.setOpaque(true);
        Exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.gameFrame.dispose();
            }
        });
        gamePanel.add(Exit);
    }

    private void addSetting() {
        setting = new JButton("Setting");
        setting.setBounds(startButton, startButton * 7, Width, Height);
        setting.setVisible(true);
        setting.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Setting");
            }
        });
        gamePanel.add(setting);
    }

    private void addHistory() {
        History = new JButton("History");
        History.setBounds(startButton, startButton * 5, Width, Height);
        History.setVisible(true);
        History.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("History");
            }
        });
        gamePanel.add(History);
    }

    private void addRecords() {
        records = new JButton("Record");
        records.setBounds(startButton, startButton * 3, Width, Height);
        records.setVisible(true);
        records.setFocusable(true);
        records.requestFocus();
        records.requestFocusInWindow();


        records.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("record");
            }
        });
        gamePanel.add(records);
    }

    private void addGame() {

        StartGame = new JButton("Game");
        StartGame.setBounds(startButton, startButton, Width, Height);
        StartGame.setVisible(true);
        StartGame.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("game");
            }
        });
        gamePanel.add(StartGame);
    }

    private void creatLogin() {
        addGame();
        addExit();
        addHistory();
        addRecords();
        addSetting();
    }
}

