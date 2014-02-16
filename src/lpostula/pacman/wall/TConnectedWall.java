package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe TConnectedWall
 */
public class TConnectedWall extends Wall {
    protected double xBoundBig;
    protected double yBoundBig;
    protected double xBoundSmall;
    protected double yBoundSmall;
    protected double widthBig;
    protected double heightBig;
    protected double widthSmall;
    protected double heightSmall;

    public TConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
    }

    public void constructCanva() {
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().setFill(Color.AQUA);
        canva.getGraphicsContext2D().fillRect(xBoundBig, yBoundBig, widthBig, heightBig);
        canva.getGraphicsContext2D().fillRect(xBoundSmall, yBoundSmall, widthSmall, heightSmall);
        node = canva;
        node.setVisible(true);
        constructLine();
    }
}
