package lpostula.pacman.wall;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe RectangleWall
 */
public abstract class RectangleWall extends Wall {
    /**
     * The X bound min.
     */
    protected double xBoundMin;
    /**
     * The X bound max.
     */
    protected double xBoundMax;
    /**
     * The Y bound min.
     */
    protected double yBoundMin;
    /**
     * The Y bound max.
     */
    protected double yBoundMax;
    /**
     * The Width.
     */
    protected double width;
    /**
     * The Height.
     */
    protected double height;
    /**
     * The Check left.
     */
    protected boolean checkLeft = true;
    /**
     * The Check right.
     */
    protected boolean checkRight = true;
    /**
     * The Check up.
     */
    protected boolean checkUp = true;
    /**
     * The Check down.
     */
    protected boolean checkDown = true;

    /**
     * Instantiates a new Rectangle wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public RectangleWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
    }

    /**
     * Construct canva.
     */
    protected void constructCanva() {
        width = xBoundMax - xBoundMin;
        height = yBoundMax - yBoundMin;
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().setFill(COLOR);
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
