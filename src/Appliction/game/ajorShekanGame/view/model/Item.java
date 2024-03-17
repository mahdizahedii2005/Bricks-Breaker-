package Appliction.game.ajorShekanGame.view.model;

public abstract class Item extends ObjectsInGame implements IMoveable,Gravity {

    public Item(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
}
