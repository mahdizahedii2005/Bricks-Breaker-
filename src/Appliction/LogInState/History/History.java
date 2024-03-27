package Appliction.LogInState.History;

import Appliction.game.ajorShekanGame.view.gameFileProcese;
import Appliction.view.GameFrame;

import javax.swing.*;
import java.util.ArrayList;

public class History {
    JScrollPane jScrollPane;
    JTable jTable;

    public History() {
        this.jTable = new JTable(getData(), getColm());
        setjTable();
        jScrollPane = new JScrollPane(jTable);
        jscrol();
        GameFrame.getGameFrame().getMainPanel().add(jTable);
        GameFrame.getGameFrame().getMainPanel().add(jScrollPane);
    }

    private String[] getColm() {
        return new String[]{"NAME", "SCORE", "DATE"};
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
        result = new String[resultArray.size()][3];
        int w = 0;
        for (ArrayList<String> arr : resultArray) {
            result[w] = (String[]) arr.toArray();
            w++;
        }
        return result;
    }
    public void setjTable(){
        jTable.setLayout(null);
        jTable.setVisible(true);
        jTable.setOpaque(true);
        jTable.setBounds(100, 100, 400, 600);
    }
    public void jscrol() {
        jScrollPane.setLayout(null);
        jScrollPane.setVisible(true);
        jScrollPane.setOpaque(true);
        jScrollPane.setBounds(100, 100, 400, 600);
    }
}
