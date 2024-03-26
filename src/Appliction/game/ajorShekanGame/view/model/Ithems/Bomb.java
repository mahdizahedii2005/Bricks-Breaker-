package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.gameMusicPlayer;
import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Brick;
import Appliction.game.ajorShekanGame.view.model.ObjectsInGame;

public class Bomb extends SpeItem{
    public Bomb(int x, int y,Integer val) {
        super(x, y+1,val);
        if (GamePanel.level.equals("hard")) {
            PhotoPath = "Pic\\Item\\Hard\\Bomb.png";
            BulItem(34, 48);
            setX(getX() + 8);
        } else if (GamePanel.level.equals("normal")) {
            PhotoPath = "Pic\\Item\\Normal\\Bomb.png";
            BulItem(63, 98);
            setX(getX() + 18);
        } else if (GamePanel.level.equals("ez")) {
            PhotoPath = "Pic\\Item\\Easy\\Bomb.png";
            BulItem(79, 123);
            setX(getX() + 23);
        }
    }

    @Override
    public void DoAction() {
        super.DoAction();
        gameMusicPlayer a =new gameMusicPlayer("Pic\\song\\bom.wav");
        new Appliction.game.ajorShekanGame.view.model.Ithems.TheredAction.Bomb(getCenterX(), getCenterY(),a).start();
        for (int i = 0; i < GamePanel.getGamePanel().brickArrayList.size(); i++) {
            Brick br = GamePanel.getGamePanel().brickArrayList.get(i);
            if (Up(br)&&Down(br)&&right(br)&&Left(br)){
                br.Explosive();
                i-=1;
            }
        }
        for (int i = 0; i < GamePanel.getGamePanel().ItemArrayList.size(); i++) {
            Item br =GamePanel.getGamePanel().ItemArrayList.get(i);
            if (br instanceof normalItem){
                if (Up(br)&&Down(br)&&right(br)&&Left(br)){
                    br.Delete();
                }
            }
        }
        GamePanel.getGamePanel().repaint();
    }
    private boolean right(ObjectsInGame br) {
        return br.getCenterX() <= br.getWidth() + getCenterX() + 15;
    }

    private boolean Left(ObjectsInGame br) {
        return br.getCenterX() >= getCenterX() - br.getWidth() - 15;
    }

    private boolean Down(ObjectsInGame br) {
        return br.getCenterY() >= getCenterY() - br.getHeight() - 15;
    }

    private boolean Up(ObjectsInGame br) {
        return br.getCenterY() <= br.getHeight() + getCenterY() + 15;
    }
}
