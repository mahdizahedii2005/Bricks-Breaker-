package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;

public class Sargijeh extends normalItem{
    public Sargijeh(int x, int y) {
        super(x, y);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\Sargijeh.png";
            BulItem(50,50);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\Sargijeh.png";
            BulItem(100,100);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\Sargijeh.png";
            BulItem(125,125);
        }
    }
    @Override
    protected void DoAction() {

    }

}
