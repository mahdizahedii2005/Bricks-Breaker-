package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Brick;

public class Bomb extends SpeItem {
    public Bomb(int x, int y) {
        super(x, y);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\Bomb.png";
            BulItem(34, 50);
            setX(getX() + 8);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\Bomb.png";
            BulItem(63, 100);
            setX(getX() + 18);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\Bomb.png";
            BulItem(79, 125);
            setX(getX() + 23);
        }
    }

    @Override
    public void DoAction() {
        new boom(getCenterX(),getCenterY()).start();
        for (int i = 0; i < GamePanel.getGamePanel().brickArrayList.size(); i++) {
            Brick br = GamePanel.getGamePanel().brickArrayList.get(i);
            if (Up(br)&&Down(br)&&right(br)&&Left(br)){
                br.Explosive();
                i-=1;
            }
        }
        GamePanel.getGamePanel().repaint();
    }

    private boolean right(Brick br) {
        return br.getCenterX() <= br.getWidth() + getCenterX() + 15;
    }

    private boolean Left(Brick br) {
        return br.getCenterX() >= getCenterX() - br.getWidth() - 15;
    }

    private boolean Down(Brick br) {
        return br.getCenterY() >= getCenterY() - br.getHeight() - 15;
    }

    private boolean Up(Brick br) {
        return br.getCenterY() <= br.getHeight() + getCenterY() + 15;
    }
}
