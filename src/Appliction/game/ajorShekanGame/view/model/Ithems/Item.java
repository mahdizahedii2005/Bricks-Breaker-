package Appliction.game.ajorShekanGame.view.model.Ithems;

import Appliction.game.ajorShekanGame.view.model.ObjectsInGame;

public class Item extends ObjectsInGame {
    protected String PhotoPath;

    public Item(int x, int y, int width, int height) {
        super(x, y, width, height);}
    public String getPhotoPath() {
        return PhotoPath;
    }
}
