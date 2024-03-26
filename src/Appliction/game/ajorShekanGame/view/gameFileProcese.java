package Appliction.game.ajorShekanGame.view;

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
    public static void WriteFile(String name, String Score, String date) {
        PrintStream n = null;
        try {
            Scanner sc = new Scanner(file);
            String bestScore = sc.nextLine();
            String a =fileWithoutBestScore();
            n = new PrintStream(file);
            PrintWriter print = new PrintWriter(n, true);
            if (Integer.parseInt(Score) > Integer.parseInt(bestScore)) {
                print.println(Score);
            } else {
                print.println(bestScore);
            }
            print.println(a);
            print.println(name + "`" + Score + "`" + date+"`");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static String readFile() {
        try {
            Scanner sc = new Scanner(file);
            String result = "";
            while (sc.hasNextLine()) {
                result += sc.nextLine();
            }
            return result;
        } catch (IOException e) {
            return null;
        }
    }
}
