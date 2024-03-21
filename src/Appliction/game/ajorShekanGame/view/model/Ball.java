package Appliction.game.ajorShekanGame.view.model;

import Appliction.game.ajorShekanGame.view.GamePanel;

import javax.swing.*;

public class Ball extends ObjectsInGame implements IMoveable {
    public boolean IsMoving;
    private float xVal = 0;
    private float yVal = 0;

    public Ball(int x, int y, int width, int height, String Path) {
        super(x, y, width, height);
        IsMoving = false;
        setBounds(x, y, width, height);
        setIcon(new ImageIcon(Path));
        setVisible(true);
        setOpaque(true);
        GamePanel.getGamePanel().add(this);
        GamePanel.getGamePanel().ballArrayList.add(this);
    }

    @Override
    public void Move() {
        boolean a, b;
        a = Hit();
        b = doWeHitBrick();
        if (a || b) {
            return;
        }
        setX(giveMeVALPlusX());
        setY(giveMeVALPlusY());
        setBounds(getX(), getY(), getWidth(), getHeight());
        repaint();
    }

    private boolean Hit() {
        boolean a, b, c, d;
        a = HitRightWall();
        b = HitUpWall();
        c = HitLeftWall();
        d = HitButtonWall();
        return a || b || c || d;
    }

    private boolean HitButtonWall() {
        if (IsMoving) {
            if (getY() + getHeight() + getyVal() > GamePanel.MaxHeight) {
                if (GamePanel.StartX == -1) {
                    GamePanel.StartX = getX();
                }
                setX(GamePanel.StartX);
                setY(GamePanel.startY);
                setBounds(getX(), getY(), getWidth(), getHeight());
                repaint();
            } else if (getY() + getHeight() + getyVal() == GamePanel.MaxHeight) {
                if (GamePanel.StartX == -1) {
                    GamePanel.StartX = getX();
                }
                setX(GamePanel.StartX);
                setY(GamePanel.startY);
                setBounds(getX(), getY(), getWidth(), getHeight());
                repaint();
            } else if (getY() + getHeight() + getyVal() < GamePanel.MaxHeight) {
                return false;
            }
            setxVal(0);
            setyVal(0);
            IsMoving = false;
            GamePanel.getGamePanel().gameLoop.isBallTrow = GamePanel.getGamePanel().gameLoop.IsBalllTrow();
            return true;
        }
        return false;
    }

    private boolean HitLeftWall() {
        if (IsMoving) {
            if (giveMeVALPlusX() < 0) {
                setX(0);
                setY(giveMeVALPlusY());
                setBounds(getX(), getY(), getWidth(), getHeight());
                repaint();
            } else if ((giveMeVALPlusX() + getWidth() == GamePanel.MaxWidth)) {
                //  this.Move();
            } else if ((giveMeVALPlusX() + getWidth() < GamePanel.MaxWidth)) {
                return false;
            }
            setxVal(-1 * getxVal());
            return true;
        }
        return false;
    }

    private boolean HitRightWall() {
        if (IsMoving) {
            if (getX() + getWidth() + getxVal() > GamePanel.MaxWidth) {
                setX(GamePanel.MaxWidth - getWidth());
                setY(giveMeVALPlusY());
                setBounds(getX(), getY(), getWidth(), getHeight());
                repaint();
            } else if ((getX() + getWidth() + getxVal() < GamePanel.MaxWidth)) {
                return false;
            }
            setxVal(-1 * getxVal());
            return true;
        }
        return false;
    }

    private boolean HitUpWall() {
        if (IsMoving) {
            if (giveMeVALPlusY() < 0) {
                setX(giveMeVALPlusX());
                setY(0);
                setBounds(getX(), getY(), getWidth(), getHeight());
                repaint();
            } else if (giveMeVALPlusY() > 0) {
                return false;
            }
            setyVal(-1 * getyVal());
            return true;
        }
        return false;
    }

    private boolean doWeHitBrick() {
        for (Brick br : GamePanel.getGamePanel().brickArrayList) {
            if (HitChooser(br)) {
                return true;
            }
        }
        return false;
    }

    private boolean HitChooser(Brick br) {
        if (DoItHit(br)) {
            if (OnLine(br)) {
                HitGosheh(br);
            } else if (R(br)) {
                HitRightBrick(br);
            } else if (U(br)) {
                HitUpBrick(br);
            } else if (L(br)) {
                HitLeftBrick(br);
            } else if (D(br)) {
                HitDownBrick(br);
            }
            return true;
        }
        return false;
    }

    private boolean DoItHit(Brick br) {
        return giveMeVALPlusX()>= br.getX() - getWidth() && giveMeVALPlusX() <= br.getX() + br.getWidth() && giveMeVALPlusY() >= br.getY() - getHeight() && giveMeVALPlusY()<= br.getHeight() + br.getY();
    }

    //    private boolean HitChooser(Brick br) {
//        int x = -1, y = -1;
//        if (BL(br)) {
//            x = getX() + getxVal() + getWidth() - br.getX();
//            y = br.getY() + br.getHeight() - getY() + getyVal();
//            // x را یک میکنیم
//            int xStep = 1;
//            int yStep = Math.round((float) yVal / xVal);
//            while (x > 0 || y > 0) {
//                x -= xStep;
//                y -= yStep;
//            }
//            if (y <= 0) {
//                HitUpBrick(br);
//            } else {
//                HitRightBrick(br);
//            }
//            return true;
//
//        } else if (BR(br)) {
//            x = -1 * (getX() + getxVal() - br.getX() - br.getWidth());
//            y = -1 * (getY() + getyVal() - br.getY() + br.getHeight());
//            // x را یک میکنیم
//            int xStep = 1;
//            int yStep = Math.round((float) yVal / xVal);
//            while (x > 0 || y > 0) {
//                x -= xStep;
//                y -= yStep;
//            }
//            if (y <= 0) {
//                HitUpBrick(br);
//            } else {
//                HitLeftBrick(br);
//            }
//            return true;
//
//        } else if (UL(br)) {
//            y = (br.getY() - getY() - getyVal() - getHeight());
//            x = getX() + getxVal() + getWidth() - br.getX();
//            // x را یک میکنیم
//            int xStep = 1;
//            int yStep = Math.round(((float) (yVal)) / xVal);
//            while (x > 0 || y > 0) {
//                x -= xStep;
//                y -= yStep;
//            }
//            if (y <= 0) {
//                System.out.println("Ul");
//                HitDownBrick(br);
//            } else {
//                HitRightBrick(br);
//            }
//            return true;
//        } else if (UR(br)) {
//            y = -br.getY() + getY() + getyVal() + getHeight();
//            x = -getX() - getxVal() + br.getX() + br.getWidth();
//            // x را یک میکنیم
//            int xStep = 1;
//            int yStep = Math.round(((float) (yVal)) / xVal);
//            while (x > 0 || y > 0) {
//                x -= xStep;
//                y -= yStep;
//            }
//            if (y <= 0) {
//                System.out.println("UR");
//                HitDownBrick(br);
//            } else {
//                HitLeftBrick(br);
//            }
//            return true;
//        }
//        return false;
//    }
    private Boolean ISItUpTheLine(int a, int h, int x, int y) {
        if (0 < y - ((a * x) + h)) {
            return true;
        } else if (y == (a * x) + h) {
            return null;
        } else {
            return false;
        }
        //ax+h=y
    }

    private boolean OnLine(Brick br) {
        int hm1 = br.getY()+br.getHeight() + br.getX() ;
        int h2 = br.getY() - br.getX() ;
        return ISItUpTheLine(-1, hm1, getCenterX(), getCenterY()) == null || ISItUpTheLine(1, h2, getCenterX(), getCenterY()) == null;
    }


    private boolean R(Brick br) {
        try {
            int hm1 = br.getY() +br.getHeight()+ br.getX();
            int h2 = br.getY() - br.getX();
            return ISItUpTheLine(-1, hm1, getCenterX(), getCenterY()) && !ISItUpTheLine(1, h2, getCenterX(), getCenterY());
        } catch (NullPointerException b) {
            return false;
        }
    }

    private boolean L(Brick br) {
        try {
            int hm1 = br.getY() +br.getHeight()+ br.getX();
            int h2 = br.getY() - br.getX();
            return !ISItUpTheLine(-1, hm1, getCenterX(), getCenterY()) && ISItUpTheLine(1, h2, getCenterX(), getCenterY());
        } catch (NullPointerException b) {
            return false;
        }

    }

    private boolean U(Brick br) {
        try {
            int hm1 = br.getY() +br.getHeight()+ br.getX();
            int h2 = br.getY() - br.getX();
            return !ISItUpTheLine(-1, hm1, getCenterX(), getCenterY()) && !ISItUpTheLine(1, h2, getCenterX(), getCenterY());
        } catch (
                NullPointerException b) {
            return false;
        }

    }

    private boolean D(Brick br) {
        try {
            int hm1 = br.getY() +br.getHeight()+ br.getX();
            int h2 = br.getY() - br.getX();
            return ISItUpTheLine(-1, hm1, getCenterX(), getCenterY()) && ISItUpTheLine(1, h2, getCenterX(), getCenterY());
        } catch (NullPointerException b) {
            return false;
        }
    }

    private void HitDownBrick(Brick br) {
        setX(giveMeVALPlusX());
        setY(giveMeVALPlusY());
//        setY(br.getY() + br.getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
  //      System.out.println("Down" + getX() + ":" + getY() + "    brick" + br.getX() + ":" + br.getY());
        br.DicreasValue();
        repaint();
        setyVal(-1 * getyVal());
    }

    private void HitRightBrick(Brick br) {
        setX(giveMeVALPlusX());
        setY(giveMeVALPlusY());
//        setX(br.getX() + br.getHeight());
//        setY(getY() + getyVal());
        setBounds(getX(), getY(), getWidth(), getHeight());
        //System.out.println("right" + getX() + ":" + getY() + "    brick" + br.getX() + ":" + br.getY());
        br.DicreasValue();
        repaint();
        setxVal(-1 * getxVal());
    }

    private void HitLeftBrick(Brick br) {
        setX(giveMeVALPlusX());
        setY(giveMeVALPlusY());
//        setX(br.getX() - getWidth());
//        setY(getY() + getyVal());
        setBounds(getX(), getY(), getWidth(), getHeight());
   //     System.out.println("left" + getX() + ":" + getY() + "    brick" + br.getX() + ":" + br.getY());
        br.DicreasValue();
        repaint();
        setxVal(-1 * getxVal());
    }

    private void HitUpBrick(Brick br) {
        setX(giveMeVALPlusX());
        setY(giveMeVALPlusY());
//        setX(getX() + getxVal());
//        setY(br.getY() - getHeight());
        setBounds(getX(), getY(), getWidth(), getHeight());
//System.out.println("up" + getX() + ":" + getY() + "    brick" + br.getX() + ":" + br.getY());
        br.DicreasValue();
        repaint();
        setyVal(-1 * getyVal());
    }

    private void HitGosheh(Brick br) {
        setX(giveMeVALPlusX());
        setY(giveMeVALPlusY());
        setBounds(getX(), getY(), getWidth(), getHeight());
    //    System.out.println("Ghoshe" + getX() + ":" + getY() + "    brick" + br.getX() + ":" + br.getY());
        br.DicreasValue();
        repaint();
        setyVal(-1 * getyVal());
        setxVal(-1 * getxVal());
    }

    public float getxVal() {
        return xVal;
    }

    public void setxVal(float xVal) {
        this.xVal = xVal;
    }

    public float getyVal() {
        return yVal;
    }

    public void setyVal(float yVal) {
        this.yVal = yVal;
    }

    public int giveMeVALPlusX() {
        return Math.round(x + xVal);
    }

    public int giveMeVALPlusY() {
        return Math.round(y + yVal);
    }
}
