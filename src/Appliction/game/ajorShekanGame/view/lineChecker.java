package Appliction.game.ajorShekanGame.view;

public class lineChecker extends Thread {
    float x, y;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public lineChecker(float x, float y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        while (GamePanel.getGamePanel().isItClick) {

//            try {
//                sleep(200);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }

    }


}
