package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;

/**
 * Created by lpostula on 15/02/14.
 * Documentation de la classe CornerWall
 */
public class CornerWall extends Wall {
    protected double xBoundMinMain;
    protected double xBoundMaxMain;
    protected double yBoundMinMain;
    protected double yBoundMaxMain;

    protected double xBoundMinSmall;
    protected double xBoundMaxSmall;
    protected double yBoundMinSmall;
    protected double yBoundMaxSmall;

    protected boolean checkLeft = true;
    protected boolean checkRight = true;
    protected boolean checkUp = true;
    protected boolean checkDown = true;


    protected double widthMain;
    protected double heightMain;
    protected double widthSmall;
    protected double heightSmall;

    public CornerWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
    }

    protected void constructCanva() {
        widthMain = xBoundMaxMain - xBoundMinMain;
        widthSmall = xBoundMaxSmall - xBoundMinSmall;
        heightMain = yBoundMaxMain - yBoundMinMain;
        heightSmall = yBoundMaxSmall - yBoundMinSmall;
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().setFill(COLOR);
        canva.getGraphicsContext2D().fillRect(xBoundMinMain, yBoundMinMain, widthMain, heightMain);
        canva.getGraphicsContext2D().fillRect(xBoundMinSmall, yBoundMinSmall, widthSmall, heightSmall);
        node = canva;
        node.setVisible(true);
        constructLine();
    }
}
