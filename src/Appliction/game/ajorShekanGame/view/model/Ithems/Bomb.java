package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;

public class Bomb extends SpeItem{
    public Bomb(int x, int y) {
        super(x, y);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\Bomb.png";
            BulItem(34,50);
            setX(getX()+8);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\Bomb.png";
            BulItem(63,100);
            setX(getX()+18);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\Bomb.png";
            BulItem(79,125);
            setX(getX()+23);
        }
    }

    @Override
    protected void DoAction() {
        super.DoAction();
    }
}
