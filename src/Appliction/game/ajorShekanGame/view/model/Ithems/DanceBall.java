package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;

public class DanceBall extends SpeItem {
    public DanceBall(int x, int y) {
        super(x, y);
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
    protected void DoAction() {
        super.DoAction();
    }


}
