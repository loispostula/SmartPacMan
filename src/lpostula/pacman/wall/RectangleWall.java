package lpostula.pacman.wall;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe RectangleWall
 */
public abstract class RectangleWall extends Wall {
    protected double xBoundMin;
    protected double xBoundMax;
    protected double yBoundMin;
    protected double yBoundMax;
    protected double width;
    protected double height;
    protected boolean checkLeft = true;
    protected boolean checkRight = true;
    protected boolean checkUp = true;
    protected boolean checkDown = true;

    public RectangleWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
    }

    protected void constructCanva() {
        width = xBoundMax - xBoundMin;
        height = yBoundMax - yBoundMin;
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().setFill(Color.AQUA);
        canva.getGraphicsContext2D().fillRect(xBoundMin, yBoundMin, width, height);
        node = canva;
        node.setVisible(true);
        constructLine();
    }

    @Override
    public void constructLine() {
        Point2D min = new Point2D(xBoundMin + posX, yBoundMin + posY);
        Point2D max = new Point2D(xBoundMax + posX, yBoundMax + posY);
        if (checkLeft) {
            lineLeft.add(new Line(min.getX(), min.getY(), min.getX(), max.getY()));
        }
        if (checkRight) {
            lineRight.add(new Line(max.getX(), min.getY(), max.getX(), max.getY()));
        }
        if (checkUp) {
            lineUp.add(new Line(min.getX(), min.getY(), max.getX(), min.getY()));
        }
        if (checkDown) {
            lineDown.add(new Line(min.getX(), max.getY(), max.getX(), max.getY()));
        }
    }
}
