package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;

public class EarthQuark extends SpeItem {
    public EarthQuark(int x, int y) {
        super(x, y);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\earthquake.png";
            BulItem(39, 50);
            setX(getX() + 5);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\earthquake.png";
            BulItem(79, 100);
            setX(getX() + 11);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\earthquake.png";
            BulItem(99, 125);
            setX(getX() + 18);
        }
    }

    @Override
    protected void DoAction() {

    }

}