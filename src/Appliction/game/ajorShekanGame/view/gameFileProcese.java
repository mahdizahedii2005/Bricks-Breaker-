package Appliction.game.ajorShekanGame.view;

import Appliction.LogInState.Setting.setting;

import java.io.*;
import java.util.Scanner;

public class gameFileProcese {
    private static final String filePath = "data\\Records.txt";
    static File file = new File(filePath);

    private static String fileWithoutBestScore() {
        try {
            Scanner sc = new Scanner(file);
            sc.nextLine();
            String result = "";
            while (sc.hasNextLine()) {
                result += sc.nextLine();
            }
            return result;
        } catch (IOException e) {
            return null;
        }
    }

    public static void WriteFile(String name, String Score, String date,String time) {
        if (setting.dataSaving){
            PrintStream n = null;
            try {
                Scanner sc = new Scanner(file);
                String bestScore = sc.nextLine();
                String a = fileWithoutBestScore();
                n = new PrintStream(file);
                PrintWriter print = new PrintWriter(n, true);
                if (Integer.parseInt(Score) > Integer.parseInt(bestScore)) {
                    print.println(Score);
                } else {
                    print.println(bestScore);
                }
                print.print(a);
                print.print(name + "`" + Score + "`" + date + "`"+time+"!");
                print.close();
                n.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String readFile() {
        try {
            Scanner sc = new Scanner(file);
            String result = "";
            sc.nextLine();
            while (sc.hasNextLine()) {
                result += sc.nextLine();
            }
            return result;
        } catch (IOException e) {
            return null;
        }
    }

    public static Integer BestScore() {
        try {
            Scanner sc = new Scanner(file);
            return sc.nextInt();
        } catch (IOException r) {
            System.out.println(r.getMessage());
        }
        return null;
    }
}
