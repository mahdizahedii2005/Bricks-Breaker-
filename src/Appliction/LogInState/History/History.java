package Appliction.LogInState.History;

import Appliction.game.ajorShekanGame.view.gameFileProcese;
import Appliction.view.GameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class History extends JPanel {
    JScrollPane jScrollPane;
    JTable jTable;
    JButton back;

    public History() {
        setOpaque(false);
        setBounds(0,0,600,800);
        this.jTable = new JTable(getData(), getColm());
        jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(100, 100, 400, 600);
        CreatBack();
        add(jScrollPane);
    }

    private String[] getColm() {
        return new String[]{"NAME", "SCORE", "DATE","TIME"};
    }

    private void CreatJbutton(JButton jButton, int x, int y, int width, int height) {
        jButton.setBounds(x, y, width, height);
        jButton.setVisible(true);
        jButton.setOpaque(true);
    }

    private void CreatBack() {
        back = new JButton(new ImageIcon("Pic\\backk.png"));
        CreatJbutton(back, 0, 0, 40, 40);
        back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameFrame.getGameFrame().newStage();
                new Appliction.LogInState.LoginPAnnel(GameFrame.getGameFrame().getMainPanel());
                GameFrame.getGameFrame().addBackGrand();
                GameFrame.getGameFrame().repaint();
            }
        });
        add(back);
    }

    private String[][] getData() {
        String a = gameFileProcese.readFile();
        String[][] result;
        ArrayList<ArrayList<String>> resultArray = new ArrayList<>();
        ArrayList<String> satrList = new ArrayList<>();
        ArrayList<Character> word = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            char t = a.charAt(i);
            if (t == '!') {
                String b = "";
                for (char c : word) {
                    b += c;
                }
                satrList.add(b);
                word = new ArrayList<>();
                resultArray.add(satrList);
                satrList = new ArrayList<>();
            } else if (t == '`') {
                String b = "";
                for (char c : word) {
                    b += c;
                }
                satrList.add(b);
                word = new ArrayList<>();
            } else {
                word.add(t);
            }
        }
        result = new String[resultArray.size()][4];
        for (int i = 0; i < resultArray.size(); i++) {
            for (int j = 0; j < 4; j++) {
                result[i][j] = resultArray.get(i).get(j);
            }
        }
        if (resultArray.size() < 40) {
            String[][] res = new String[40][4];
            for (int i = 0; i < resultArray.size(); i++) {
                for (int j = 0; j < 4; j++) {
                    res[i][j] = result[i][j];
                }
            }
            for (int i = resultArray.size(); i < 40; i++) {
                for (int j = 0; j < 4; j++) {
                    res[i][j] = " ";
                }
            }
            return res;
        }
        return result;
    }

}
