package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;

public class IncreaseBallPower extends normalItem {
    public IncreaseBallPower(int x, int y) {
        super(x, y);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\IncreasPower.png";
            BulItem(50, 50);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\IncreasPower.png";
            BulItem(100, 100);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\IncreasPower.png";
            BulItem(125, 125);
        }

    }

    @Override
    protected void DoAction() {

    }

}