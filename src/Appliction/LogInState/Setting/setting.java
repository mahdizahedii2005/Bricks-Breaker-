package Appliction.LogInState.Setting;

import Appliction.LogInState.LoginPAnnel;
import Appliction.view.GameFrame;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;

public class setting {
    private JButton back;
    private JPanel settingPanel;
    private JButton yesButton;
    private JButton NoButton;
    private JButton active;
    private JButton inActive;
    private JSlider soundController;
    private JLabel soundPhoto;
    private JLabel SettingName;
    private JLabel AmingPhoto;
    private JLabel SaveRecords;
    private static final int basePlace = 110;
    private static final int width = 450;
    private static final int potoSize = 45;
    private static final String WActivePath = "Pic\\W-ACTIVE.png";
    private static final String RInActivePath = "Pic\\R-INACTIVE.png";
    private static final String WInActivePath = "Pic\\w-inactive.png";
    private static final String RActivePath = "Pic\\R-ACTIVE.png";

    private static final String WN = "Pic\\W-no.png";
    private static final String RY = "Pic\\R-yes.png";
    private static final String WY = "Pic\\W-Yes.png";
    private static final String RN = "Pic\\R-no.png";
    private static String CurrentYPath = WY;
    private static String CurrentNPath = RN;

    private static String CurrentActivePath = WActivePath;
    private static String CurrentInActivePath = RInActivePath;

    private static int volume = 40;

    public setting(JPanel mainPanel) {
        CreatSettingPanel();
        creatSettingPanelCom();
        mainPanel.add(settingPanel);
    }

    public void CreatSettingPanel() {
        settingPanel = new JPanel();
        settingPanel.setBounds(0, 0, 600, 800);
        settingPanel.setFocusable(true);
        settingPanel.requestFocus();
        settingPanel.requestFocusInWindow();
        settingPanel.setLayout(null);
        settingPanel.setOpaque(false);
    }

    public void creatSettingPanelCom() {
        addSoundController();
        addSettingName();
        addAiming();
        addActive();
        addInActive();
        addSaveRecord();
        addNo();
        addYes();
        addBack();
    }

    private void addSoundController() {
        soundController = new JSlider(JSlider.HORIZONTAL, 0, 100, volume);
        soundController.setBounds(basePlace, (basePlace * 3) - 150, width, potoSize);
        soundController.setVisible(true);
        soundController.setOpaque(true);
        soundController.setFocusable(true);
        soundController.requestFocus();
        soundController.requestFocusInWindow();
        soundController.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                volume = soundController.getValue();
            }
        });
        settingPanel.add(soundController);
        soundPhoto = new JLabel(new ImageIcon("Pic\\images.png"));
        soundPhoto.setBounds((basePlace - potoSize) / 2, (basePlace * 3) - 150, potoSize, potoSize);
        soundPhoto.setVisible(true);
        soundPhoto.setOpaque(true);
        settingPanel.add(soundPhoto);
    }
    private void addSettingName() {
        SettingName = new JLabel(new ImageIcon("Pic\\sETING.png"));
        SettingName.setBounds(125, 25, 350, 60);
        SettingName.setVisible(true);
        SettingName.setOpaque(true);
        settingPanel.add(SettingName);
    }
    private void addAiming() {
        AmingPhoto = new JLabel(new ImageIcon("Pic\\Aiming.png"));
        AmingPhoto.setBounds(200, 370, 200, 60);
        AmingPhoto.setVisible(true);
        AmingPhoto.setOpaque(true);
        settingPanel.add(AmingPhoto);
    }
//red IS that been picked
    private void addActive() {
        active = new JButton(new ImageIcon(CurrentActivePath));
        active.setBounds(40, 385, 142, 32);
        active.setVisible(true);
        active.setOpaque(true);
        active.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CurrentActivePath.equals(WActivePath)) {
                    CurrentActivePath = RActivePath;
                    CurrentInActivePath = WInActivePath;
                    settingPanel.remove(active);
                    settingPanel.remove(inActive);
                    addActive();
                    addInActive();
                    GameFrame.getGameFrame().revalidate();
                    GameFrame.getGameFrame().repaint();
                }
            }
        });
        settingPanel.add(active);
    }
    private void addInActive() {
        inActive = new JButton(new ImageIcon(CurrentInActivePath));
        inActive.setBounds(410, 385, 165, 32);
        inActive.setVisible(true);
        inActive.setOpaque(true);
        inActive.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {if (CurrentInActivePath.equals(WInActivePath)) {
                    CurrentActivePath = WActivePath;
                    CurrentInActivePath = RInActivePath;
                    settingPanel.remove(active);
                    settingPanel.remove(inActive);
                    addActive();
                    addInActive();
                    GameFrame.getGameFrame().revalidate();
                    GameFrame.getGameFrame().repaint();
                }}});
        settingPanel.add(inActive);
    }
    private void addSaveRecord() {
        SaveRecords = new JLabel(new ImageIcon("Pic\\SaveRecourdPhoto.png"));
        SaveRecords.setBounds(100, 550, 400, 43);
        SaveRecords.setVisible(true);
        SaveRecords.setOpaque(true);
        settingPanel.add(SaveRecords);
    }
    private void addYes() {
        yesButton = new JButton(new ImageIcon(CurrentYPath));
        yesButton.setBounds(25, 550, 43, 43);
        yesButton.setVisible(true);
        yesButton.setOpaque(true);
        yesButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CurrentYPath.equals(WY)) {
                    CurrentYPath = RY;
                    CurrentNPath = WN;
                    settingPanel.remove(yesButton);
                    settingPanel.remove(NoButton);
                    addNo();
                    addYes();
                    GameFrame.getGameFrame().revalidate();
                    GameFrame.getGameFrame().repaint();
                }
            }
        });
        settingPanel.add(yesButton);
    }
    private void addNo() {
        NoButton = new JButton(new ImageIcon(CurrentNPath));
        NoButton.setBounds(525, 550, 43, 43);
        NoButton.setVisible(true);
        NoButton.setOpaque(true);
        NoButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CurrentNPath.equals(WN)) {
                    CurrentYPath = WY;
                    CurrentNPath = RN;
                    settingPanel.remove(yesButton);
                    settingPanel.remove(NoButton);
                    addNo();
                    addYes();
                    GameFrame.getGameFrame().revalidate();
                    GameFrame.getGameFrame().repaint();
                }
            }
        });
        settingPanel.add(NoButton);
    }
    private void addBack() {
        back = new JButton(new ImageIcon("Pic\\back.png"));
        back.setBounds(204, 690, 192, 52);
        back.setVisible(true);
        back.setOpaque(true);
        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame.getGameFrame().newStage();
                new LoginPAnnel(GameFrame.getGameFrame().getMainPanel());
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().repaint();
            }
        });
        settingPanel.add(back);
    }
}
