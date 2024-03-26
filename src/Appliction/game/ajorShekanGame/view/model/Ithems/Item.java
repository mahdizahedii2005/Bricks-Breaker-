package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.GamePanel;
import Appliction.game.ajorShekanGame.view.model.Gravity;
import Appliction.game.ajorShekanGame.view.model.ObjectsInGame;

import javax.swing.*;

public abstract class Item extends ObjectsInGame implements Gravity {
    protected String PhotoPath;

    public Item(int x, int y) {
        super(x, y);
    }
    protected Item(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    protected void BulItem(int width , int height){
        setWidth(width);
        setHeight(height);
        setBounds(getX(), getY(), getWidth(), getHeight());
        setIcon(new ImageIcon(PhotoPath));
        setVisible(true);
        setOpaque(true);
        GamePanel.getGamePanel().firstBrick.add(this);
        GamePanel.getGamePanel().gravityObject.add(this);
        GamePanel.getGamePanel().ItemArrayList.add(this);
        GamePanel.getGamePanel().add(this);
        GamePanel.getGamePanel().repaint();
    }
    public void DoAction(){
     Delete();
    }
    public void Delete(){
        GamePanel.getGamePanel().remove(this);
        GamePanel.getGamePanel().ItemArrayList.remove(this);
        GamePanel.getGamePanel().gravityObject.remove(this);
        GamePanel.getGamePanel().repaint();
    }
    @Override
    public void Gravity(int mizan) {
        setY(getY() + mizan);
        setBounds(getX(), getY(), getWidth(), getWidth());
    }

    public String getPhotoPath() {
        return PhotoPath;
    }
}
