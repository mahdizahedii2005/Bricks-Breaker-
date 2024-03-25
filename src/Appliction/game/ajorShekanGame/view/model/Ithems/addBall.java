package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.Controler.gameLoop;
import Appliction.game.ajorShekanGame.view.GamePanel;

public class addBall extends normalItem {
    public addBall(int x, int y) {
        super(x, y);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\addBall.png";
            BulItem(50, 50);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\dBall.png";
            BulItem(100, 100);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\addBall.png";
            BulItem(125, 125);
        }
    }

    @Override
    public void DoAction() {
        gameLoop.NUMBER_OF_BALL_TO_IN_THIS_ROUND++;
    }
}
