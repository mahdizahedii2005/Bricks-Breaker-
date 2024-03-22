package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;

public class Hp extends normalItem{
    public Hp(int x, int y) {
        super(x, y);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\Hp.png";
            BulItem(125, 125);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\Hp.png";
            BulItem(100, 100);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\Hp.png";
            BulItem(50, 50);
        }

    }
    @Override
    protected void DoAction() {

    }
}
