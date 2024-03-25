package Appliction.LogInState;

import Appliction.Application;
import Appliction.view.GameFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class LoginPAnnel {
    private JPanel mainpanel;
    protected JPanel loginPanel;
    private JPanel background;
    private JButton StartGame;
    private JButton records;
    private JButton History;
    private JButton setting;
    private JButton Exit;
    private final int startButton = 65;
    private final int Height = 71;
    private final int Width = 450;


    public LoginPAnnel(JPanel MainPanel) {
        mainpanel = MainPanel;
        loginPanel = new JPanel();
        loginPanel.setBounds(0, 0, 600, 800);
        loginPanel.setVisible(true);
        loginPanel.setFocusable(true);
        loginPanel.requestFocus();
        loginPanel.requestFocusInWindow();
        loginPanel.setLayout(null);
        loginPanel.setOpaque(false);
        this.background = Appliction.LogInState.background.getBackgrand();
        creatLogin();
        mainpanel.add(loginPanel);
        loginPanel.repaint();
    }

    public JPanel getBackground() {
        return background;
    }

    private void addExit() {
        Exit = new JButton(new ImageIcon("Pic\\EXET.png"));
        Exit.setBounds(startButton, startButton * 9, Width, Height);
        Exit.setVisible(true);
        Exit.setOpaque(true);
        Exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Application.gameFrame.dispose();
            }
        });
        loginPanel.add(Exit);
    }

    private void addSetting() {
        setting = new JButton(new ImageIcon("Pic\\sETINGB.png"));
        setting.setBounds(startButton, startButton * 7, Width, Height);
        setting.setVisible(true);
        setting.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame.getGameFrame().newStage();
                new Appliction.LogInState.Setting.setting(GameFrame.getGameFrame().getMainPanel());
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().repaint();
            }
        });
        loginPanel.add(setting);

    }

    private void addHistory() {
        History = new JButton(new ImageIcon("Pic\\history.png"));
        History.setBounds(startButton, startButton * 5, Width, Height);
        History.setVisible(true);
        History.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("History");
            }
        });
        loginPanel.add(History);
    }

    private void addRecords() {
        records = new JButton(new ImageIcon("Pic\\records.png"));
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
        loginPanel.add(records);
    }

    private void addGame() {
        StartGame = new JButton(new ImageIcon("Pic\\game.png"));
        StartGame.setBounds(startButton, startButton, Width, Height);
        StartGame.setVisible(true);
        StartGame.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame.getGameFrame().newStage();
                new Appliction.game.readyState(GameFrame.getGameFrame().getMainPanel());
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().repaint();
            }
        });
        loginPanel.add(StartGame);
    }

    private void creatLogin() {
        addGame();
        addExit();
        addHistory();
        addRecords();
        addSetting();
    }
}

