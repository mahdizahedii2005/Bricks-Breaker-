package Appliction.game.ajorShekanGame.view.model;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Ithems.SpeItem;
import Appliction.view.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static Appliction.game.ajorShekanGame.view.model.CreatBrick.*;

public class Brick extends ObjectsInGame implements Gravity {
    public static int BALL_POWER = 1;

    public boolean isItSpe() {
        return isItSpe;
    }

    public void setItSpe(boolean itSpe) {
        isItSpe = itSpe;
    }

    private final int firstValue;
    private String Path;
    Integer value;
    private boolean isItSpe;
    private SpeItem speItem;

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Brick(int x, int y, int width, int height, Integer value, SpeItem speItem) {
        super(x, y, width, height);
        firstValue = value;
        this.value = value;
        this.speItem = speItem;
        setBackground(Color.BLACK);
        isItSpe = true;
    }

    public Brick(int x, int y, int width, int height, Integer value, String Path) {
        super(x, y, width, height);
        isItSpe = false;
        this.firstValue = value;
        this.value = value;
        this.Path = Path;
        setFont(new Font("Arial", Font.ITALIC, 17));
        setIcon(new ImageIcon(Path));
        setText(value.toString());
        setHorizontalTextPosition(JLabel.CENTER);
    }

    public static boolean Vallide(int x, int y, int width, int height) {
        for (Brick br : GamePanel.getGamePanel().brickArrayList) {
            if (x > br.getX() - width && x < br.getX() + br.getWidth() && y > br.getY() - height && y < br.getHeight() + br.getY()) {
                return false;
            }
        }
        return true;
    }

    public void Explosive() {
        value -= 50;
        if (value <= 0) {
            GamePanel.getGamePanel().getScoreHandeler().increaseScore(firstValue);
            GameFrame.getGameFrame().repaint();
            GamePanel.getGamePanel().gravityObject.remove(this);
            GamePanel.getGamePanel().brickArrayList.remove(this);
            GamePanel.getGamePanel().remove(this);
            if (isItSpe) {
                speItem.DoAction();
            }
        }
    }

    public void DicreasValue() {
        this.value -= BALL_POWER;
        if (value <= 0) {
            GamePanel.getGamePanel().getScoreHandeler().increaseScore(firstValue);
            GameFrame.getGameFrame().repaint();
            GamePanel.getGamePanel().gravityObject.remove(this);
            GamePanel.getGamePanel().brickArrayList.remove(this);
            GamePanel.getGamePanel().remove(this);
            GamePanel.getGamePanel().repaint();
            if (isItSpe) {
                speItem.DoAction();
            }
            return;
        }
        if (!isItSpe) {
            setText(value.toString());
            String path = Path;
            Random random = new Random();
            while (path.equals(Path)) {
                if (GamePanel.level.equals("hard")) {
                    path = ColorBrickHard.get(random.nextInt(ColorBrickHard.size()));
                } else if (GamePanel.level.equals("normal")) {
                    path = ColorBrickNormal.get(random.nextInt(ColorBrickHard.size()));
                } else if (GamePanel.level.equals("ez")) {
                    path = ColorBrickEz.get(random.nextInt(ColorBrickEz.size()));
                }
            }
            setIcon(new ImageIcon(path));
            repaint();
        } else {
            speItem.kamshodam(value);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public void Gravity(int mizan) {
        setY(getY() + mizan);
        setBounds(getX(), getY(), getWidth(), getWidth());
    }

    @Override
    public String toString() {
        return getValue() + ", X:" + getCenterX() + ", Y:" + getCenterY();
    }
}
