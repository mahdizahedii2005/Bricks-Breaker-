package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.Controler.gameLoop;
import Appliction.game.ajorShekanGame.view.GamePanel;

public class Rev extends normalItem {
    public Rev(int x, int y) {
        super(x, y);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\Rev.png";
            BulItem(32, 50);
            setX(getX() + 9);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\Rev.png";
            BulItem(64, 100);
            setX(getX() + 18);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\Rev.png";
            BulItem(81, 125);
            setX(getX() + 22);
        }
    }

    @Override
    public void DoAction() {
        gameLoop.IS_IT_REV = true;
    }
}
