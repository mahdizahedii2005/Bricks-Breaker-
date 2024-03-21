package Appliction.game.ajorShekanGame.view.model;

import Appliction.game.ajorShekanGame.view.GamePanel;

import java.util.ArrayList;
import java.util.Random;

public class CreatBrick {
    public static ArrayList<String> ColorBrick = new ArrayList<>();

    static {
        ColorBrick.add("Pic\\Brick\\Green.png");
        ColorBrick.add("Pic\\Brick\\Black.png");
        ColorBrick.add("Pic\\Brick\\HeavyBlue.png");
        ColorBrick.add("Pic\\Brick\\LightBlue.png");
        ColorBrick.add("Pic\\Brick\\Purple.png");
        ColorBrick.add("Pic\\Brick\\Red.png");
        ColorBrick.add("Pic\\Brick\\Yellow.png");
    }

    private int NumCreat;
    private Random random = new Random();
    private int numSart;
    private int valueOfBrick;
    private GamePanel gamePanel;

    public CreatBrick(int numSatr, int valueOfBrick, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.numSart = numSatr;
        this.valueOfBrick = valueOfBrick;
    }

    private String ChooseWhichStack() {
        NumCreat = random.nextInt(numSart) + 1;
        StringBuilder result = new StringBuilder();
        int numOf1 = 0;
        for (int i = 0; i < numSart; i++) {
            if (NumCreat >= numOf1) {
                int IthemBAshe = random.nextInt(7);
                if (IthemBAshe != 0) {
                    int maghsod = random.nextInt(2);
                    if (maghsod == 1) {
                        numOf1++;
                    }
                    result.append(maghsod);
                }else {
                    result.append("2");
                }
            } else {
                result.append("0");
            }
        }
        return result.toString();
    }

    public void BulAnSatr() {
        String which = ChooseWhichStack();
        GamePanel.getGamePanel().firstBrick = new ArrayList<>();
        for (int i = 0; i < numSart; i++) {
            if (which.charAt(i) == '1') {
                Brick brick = new Brick((i * 500 / numSart), -500 / numSart + 5, 500 / numSart, 500 / numSart, valueOfBrick, ColorBrick.get(random.nextInt(ColorBrick.size())));
                gamePanel.add(brick);
                gamePanel.firstBrick.add(brick);
                gamePanel.brickArrayList.add(brick);
            }
        }
        GamePanel.getGamePanel().gameLoop.CurrentValue++;
    }

    public void CustomCreat() {
        int soton = GamePanel.getGamePanel().firstBrick.get(0).getY() - GamePanel.getGamePanel().firstBrick.get(0).getHeight();
        GamePanel.getGamePanel().firstBrick = new ArrayList<>();
        String which = ChooseWhichStack();
        for (int i = 0; i < numSart; i++) {
            if (which.charAt(i) == '1') {
                Brick brick = new Brick((i * 500 / numSart), soton, 500 / numSart, 500 / numSart, valueOfBrick, ColorBrick.get(random.nextInt(ColorBrick.size())));
                gamePanel.add(brick);
                gamePanel.firstBrick.add(brick);
                gamePanel.brickArrayList.add(brick);
            }
        }
        GamePanel.getGamePanel().gameLoop.CurrentValue++;
    }

}
