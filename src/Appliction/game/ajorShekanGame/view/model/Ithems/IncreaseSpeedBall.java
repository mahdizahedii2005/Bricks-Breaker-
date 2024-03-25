package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Ithems.TheredAction.IncreaseSpeed;

public class IncreaseSpeedBall extends normalItem {
    public IncreaseSpeedBall(int x, int y) {
        super(x, y);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\IncreaseSpeed.png";
            BulItem(50, 50);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\IncreaseSpeed.png";
            BulItem(100, 100);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\IncreaseSpeed.png";
            BulItem(125, 125);
        }
    }

    @Override
    public void DoAction() {
        new IncreaseSpeed().start();
    }
}
