package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Ithems.TheredAction.Dance.brickColorChanger;
import Appliction.game.ajorShekanGame.view.model.Ithems.TheredAction.Dance.changBackGround;

public class DanceBall extends SpeItem {
    public DanceBall(int x, int y,Integer a) {
        super(x, y,a);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\Dance.png";
            BulItem(36,50);
            setX(getX()+7);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\Dance.png";
            BulItem(74,100);
            setX(getX()+13);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\Dance.png";
            BulItem(90,125);
            setX(getX()+18);
        }
    }

    @Override
    public void DoAction() {
        super.DoAction();
       new changBackGround().start();
       new brickColorChanger().start();
    }


}
