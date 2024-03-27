package Appliction.game.ajorShekanGame.view.model;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Ithems.*;

import java.util.ArrayList;
import java.util.Random;

public class CreatBrick {
    private static int period = 1;
    private int chanceFor1, chanceFor2, chanceFor3;
    public static ArrayList<String> ColorBrickHard = new ArrayList<>();
    int rate;

    static {
        ColorBrickHard.add("Pic\\Brick\\Green.png");
        ColorBrickHard.add("Pic\\Brick\\Black.png");
        ColorBrickHard.add("Pic\\Brick\\HeavyBlue.png");
        ColorBrickHard.add("Pic\\Brick\\LightBlue.png");
        ColorBrickHard.add("Pic\\Brick\\Purple.png");
        ColorBrickHard.add("Pic\\Brick\\Red.png");
        ColorBrickHard.add("Pic\\Brick\\Yellow.png");
    }

    public static ArrayList<String> ColorBrickNormal = new ArrayList<>();

    static {
        ColorBrickNormal.add("Pic\\Brick\\normal\\Yellow.png");
        ColorBrickNormal.add("Pic\\Brick\\normal\\Red.png");
        ColorBrickNormal.add("Pic\\Brick\\normal\\Purple.png");
        ColorBrickNormal.add("Pic\\Brick\\normal\\LightBlue.png");
        ColorBrickNormal.add("Pic\\Brick\\normal\\Black.png");
        ColorBrickNormal.add("Pic\\Brick\\normal\\Green.png");
        ColorBrickNormal.add("Pic\\Brick\\normal\\HeavyBlue.png");
    }

    public static ArrayList<String> ColorBrickEz = new ArrayList<>();

    static {
        ColorBrickEz.add("Pic\\Brick\\ez\\Yellow.png");
        ColorBrickEz.add("Pic\\Brick\\ez\\Red.png");
        ColorBrickEz.add("Pic\\Brick\\ez\\Purple.png");
        ColorBrickEz.add("Pic\\Brick\\ez\\LightBlue.png");
        ColorBrickEz.add("Pic\\Brick\\ez\\Black.png");
        ColorBrickEz.add("Pic\\Brick\\ez\\Green.png");
        ColorBrickEz.add("Pic\\Brick\\ez\\HeavyBlue.png");
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
        if (GamePanel.level.equals("ez")) {
            chanceFor1 = 85;
            chanceFor2 = 20;
            chanceFor3 = 10;
            rate = 14;
        } else if (GamePanel.level.equals("normal")) {
            chanceFor1 = 85;
            chanceFor2 = 15;
            chanceFor3 = 5;
            rate = 12;
        } else if (GamePanel.level.equals("hard")) {
            chanceFor1 = 65;
            chanceFor2 = 10;
            chanceFor3 = 5;
            rate = 10;
        }
    }

    private String ChooseWhichStack() {
        NumCreat = random.nextInt(numSart) + 1;
        StringBuilder result = new StringBuilder();
        int numOf1 = 0;
        for (int i = 0; i < numSart; i++) {
            int ItemBAshe = random.nextInt(100);
            if (ItemBAshe < chanceFor3) {
                result.append("3");
            } else if (ItemBAshe < chanceFor2) {
                result.append("2");
            } else if (ItemBAshe < chanceFor1) {
                if (NumCreat >= numOf1) {
                    int maghsod = random.nextInt(2);
                    if (maghsod == 1) {
                        numOf1++;
                    }
                    result.append("1");
                } else {
                    result.append("0");
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
        //nothing 0
        //Brick 1
        //Normal item 2
        //spe item 3
        boolean gointo = false;
        for (int i = 0; i < numSart; i++) {
            String path = "";
            if (GamePanel.level.equals("hard")) {
                path = ColorBrickHard.get(random.nextInt(Math.abs(ColorBrickHard.size())));
            } else if (GamePanel.level.equals("normal")) {
                path = ColorBrickNormal.get(random.nextInt(Math.abs(ColorBrickHard.size())));
            } else if (GamePanel.level.equals("ez")) {
                path = ColorBrickEz.get(random.nextInt(Math.abs(ColorBrickHard.size())));
            }
            if (Brick.Vallide((i * 500 / numSart), -500 / numSart, 500 / numSart, 500 / numSart)) {
                gointo = true;
                if (which.charAt(i) == '1') {
                    Brick brick = new Brick((i * 500 / numSart), -500 / numSart, 500 / numSart, 500 / numSart, valueOfBrick, path);
                    gamePanel.add(brick);
                    gamePanel.gravityObject.add(brick);
                    gamePanel.firstBrick.add(brick);
                    gamePanel.brickArrayList.add(brick);
                } else if (which.charAt(i) == '2') {
                    int chooser = random.nextInt(100);
                    if (chooser < 5 && GamePanel.Hp) {
                        new Hp((i * 500 / numSart), -500 / numSart);
                        GamePanel.Hp = false;
                    } else if (chooser < 20) {
                        new Rev((i * 500 / numSart), -500 / numSart);
                    } else if (chooser < 50) {
                        new Sargijeh((i * 500 / numSart), -500 / numSart);
                    } else if (chooser < 60) {
                        new IncreaseBallPower((i * 500 / numSart), -500 / numSart);
                    } else if (chooser < 80) {
                        new IncreaseSpeedBall((i * 500 / numSart), -500 / numSart);
                    } else {
                        new addBall((i * 500 / numSart), -500 / numSart);
                    }
                } else if (which.charAt(i) == '3') {
                    int chooser = random.nextInt(100);
                    SpeItem Spe;
                    if (chooser < 50) {
                        Spe = new Bomb((i * 500 / numSart), -500 / numSart, valueOfBrick);
                        Brick brick = new Brick((i * 500 / numSart), -500 / numSart, 500 / numSart, 500 / numSart, valueOfBrick, Spe);
                        gamePanel.add(brick);
                        gamePanel.firstBrick.add(brick);
                        gamePanel.brickArrayList.add(brick);
                        gamePanel.gravityObject.add(brick);
                    } else if (chooser < 90) {
                        Spe = new DanceBall((i * 500 / numSart), -500 / numSart, valueOfBrick);
                        Brick brick = new Brick((i * 500 / numSart), -500 / numSart, 500 / numSart, 500 / numSart, valueOfBrick, Spe);
                        gamePanel.add(brick);
                        gamePanel.firstBrick.add(brick);
                        gamePanel.brickArrayList.add(brick);
                        gamePanel.gravityObject.add(brick);
                    }
                }
            }
        }
        if (gointo) {
            GamePanel.getGamePanel().gameLoop.CurrentValue++;
        }
    }

    public void CustomCreat() {
        int soton;
        try {
            try {
                soton = GamePanel.getGamePanel().firstBrick.get(0).getY() - GamePanel.getGamePanel().firstBrick.get(0).getHeight();
            } catch (IndexOutOfBoundsException e) {
                soton = -500 / numSart;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            soton = -500 / numSart;
        }
        GamePanel.getGamePanel().firstBrick = new ArrayList<>();
        String which = ChooseWhichStack();
        boolean gointo = false;
        for (int i = 0; i < numSart; i++) {
            String path = "";
            if (GamePanel.level.equals("hard")) {
                path = ColorBrickHard.get(random.nextInt(ColorBrickHard.size()));
            } else if (GamePanel.level.equals("normal")) {
                path = ColorBrickNormal.get(random.nextInt(ColorBrickHard.size()));
            } else if (GamePanel.level.equals("ez")) {
               // System.out.println(ColorBrickEz.size());
                path = ColorBrickEz.get(random.nextInt(ColorBrickEz.size()));
            }
            if (Brick.Vallide((i * 500 / numSart), soton, 500 / numSart, 500 / numSart)) {
                gointo = true;
                if (which.charAt(i) == '1') {
                    Brick brick = new Brick((i * 500 / numSart), soton, 500 / numSart, 500 / numSart, valueOfBrick, path);
                    gamePanel.add(brick);
                    gamePanel.firstBrick.add(brick);
                    gamePanel.brickArrayList.add(brick);
                    gamePanel.gravityObject.add(brick);
                } else if (which.charAt(i) == '2') {
                    int chooser = random.nextInt(100);
                    if (chooser < 5) {
                        new Hp((i * 500 / numSart), soton);
                    } else if (chooser < 20) {
                        new Rev((i * 500 / numSart), soton);
                    } else if (chooser < 50) {
                        new Sargijeh((i * 500 / numSart), soton);
                    } else if (chooser < 70) {
                        new IncreaseBallPower((i * 500 / numSart), soton);
                    } else if (chooser < 80) {
                        new IncreaseSpeedBall((i * 500 / numSart), soton);
                    } else {
                        new addBall((i * 500 / numSart), soton);
                    }
                } else if (which.charAt(i) == '3') {
                    int chooser = random.nextInt(100);
                    SpeItem Spe;
                    if (chooser < 50) {
                        Spe = new Bomb((i * 500 / numSart), soton, valueOfBrick);
                        Brick brick = new Brick((i * 500 / numSart), soton, 500 / numSart, 500 / numSart, valueOfBrick, Spe);
                        gamePanel.add(brick);
                        gamePanel.firstBrick.add(brick);
                        gamePanel.brickArrayList.add(brick);
                        gamePanel.gravityObject.add(brick);
                    } else if (chooser < 80) {
                        Spe = new DanceBall((i * 500 / numSart), soton, valueOfBrick);
                        Brick brick = new Brick((i * 500 / numSart), soton, 500 / numSart, 500 / numSart, valueOfBrick, Spe);
                        gamePanel.add(brick);
                        gamePanel.firstBrick.add(brick);
                        gamePanel.brickArrayList.add(brick);
                        gamePanel.gravityObject.add(brick);
                    }
                }
            }
        }
        if (gointo) {
            CreatBrick.period++;
            if (CreatBrick.period % rate == 0) {
                GamePanel.getGamePanel().gameLoop.CurrentValue += 3;
                GamePanel.getGamePanel().gameLoop.SpeedOfBrickP++;
            } else {
                GamePanel.getGamePanel().gameLoop.CurrentValue++;
            }
        }
    }
}
