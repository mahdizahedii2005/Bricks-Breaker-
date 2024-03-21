package Appliction.game.ajorShekanGame.view.model;

import Appliction.game.ajorShekanGame.view.model.Ithems.Item;

public class CreatItem<I extends Appliction.game.ajorShekanGame.view.model.Ithems.Item> {
    int x,y,width,height;

    public CreatItem(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        I item = (I) new Item(x,y,width,height);
    }
}
