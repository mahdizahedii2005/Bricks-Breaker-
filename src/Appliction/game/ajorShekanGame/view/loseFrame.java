package Appliction.game.ajorShekanGame.view;

import Appliction.view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class loseFrame extends JFrame {
    JButton playAgain;
    JButton newsetting;
    JLabel youLose;

    public loseFrame() {
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("GAME OVER");
        setLayout(null);
        setSize(300, 200);
        setVisible(true);
        JPanel main = new JPanel();
        main.setBounds(0, 0, 300, 200);
        setContentPane(main);
        main.setLayout(null);
        youLose = new JLabel();
        youLose.setVisible(true);
        youLose.setIcon(new ImageIcon("Pic\\gameover.png"));
        youLose.setBounds(75, 5, 150, 26);
        playAgain = new JButton();
        playAgain.setVisible(true);
        playAgain.setBounds(90, 50, 120, 30);
        playAgain.setText("PLAY AGAIN");
        playAgain.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String level = GamePanel.level, ballPath = GamePanel.getBallPAth(), personName = GamePanel.getGamePanel().getPersonName();
                dispose();
                GamePanel.getGamePanel().musicPlayer.Stop();
                GamePanel.getGamePanel().musicPlayer.close();
               // gameFileProcese.WriteFile(GamePanel.getGamePanel().getPersonName(), GamePanel.getGamePanel().getScoreHandeler().getCurrentScore().toString(), LocalDate.now().toString(), LocalTime.now().toString());
                GameFrame.getGameFrame().newStage();
                new Appliction.LogInState.LoginPAnnel(GameFrame.getGameFrame().getMainPanel());
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().newStage();
                GameFrame.getGameFrame().add(new GameState(level, ballPath, personName));
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().repaint();
            }
        });
        newsetting = new JButton();
        newsetting.setText("SET NEW SETTING");
        newsetting.setBounds(75, 100, 150, 30);
        newsetting.setOpaque(true);
        newsetting.setVisible(true);
        newsetting.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                GamePanel.getGamePanel().musicPlayer.Stop();
                GamePanel.getGamePanel().musicPlayer.close();
             //   gameFileProcese.WriteFile(GamePanel.getGamePanel().getPersonName(), GamePanel.getGamePanel().getScoreHandeler().getCurrentScore().toString(), LocalDate.now().toString(), LocalTime.now().toString());
                GameFrame.getGameFrame().newStage();
                new Appliction.LogInState.LoginPAnnel(GameFrame.getGameFrame().getMainPanel());
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().newStage();
                new Appliction.game.readyState(GameFrame.getGameFrame().getMainPanel());
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().repaint();
            }
        });
        main.add(newsetting);
        main.add(youLose);
        main.add(playAgain);
    }
}
