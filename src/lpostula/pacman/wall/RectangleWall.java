package lpostula.pacman.wall;

import javafx.geometry.BoundingBox;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lpostula.gameengine.Sprite;
import lpostula.pacman.PacMan;

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

    public RectangleWall(double dimension) {
        super(dimension);
    }

    protected void constructCanva() {
        width = xBoundMax - xBoundMin;
        height = yBoundMax - yBoundMin;
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().setFill(Color.AQUA);
        canva.getGraphicsContext2D().fillRect(xBoundMin, yBoundMin, width, height);
        node = canva;
        node.setVisible(true);
    }

    private BoundingBox getBound() {
        return new BoundingBox(
                xBoundMin + node.getTranslateX(),
                yBoundMin + node.getTranslateY(),
                width,
                height
        );
    }

    public double getDistance(Point2D A, Point2D B, Point2D C) {
        double sx = B.getX() - A.getX();
        double sy = B.getY() - A.getY();
        double ux = C.getX() - A.getX();
        double uy = C.getY() - A.getY();

        double dp = sx * ux + sy * uy;
        if (dp < 0) {
            return A.distance(C);
        }
        double sn2 = sx * sx + sy * sy;
        if (dp > sn2) {
            return B.distance(C);
        }
        double ah2 = dp * dp / sn2;
        double un2 = ux * ux + uy * uy;
        return Math.sqrt(un2 - ah2);
    }

    @Override
    public boolean collide(Sprite other) {
        boolean collide = false;
        BoundingBox bound = getBound();
        if (other instanceof PacMan) {
            PacMan cand = (PacMan) other;
            Circle circle = (Circle) cand.node;
            Point2D x = null;
            Point2D y = null;
            Point2D center = cand.node.localToParent(circle.getCenterX(), circle.getCenterY());
            boolean skip = true;
            switch (cand.getDirection()) {
                case 0:
                    //left
                    if (checkLeft) {
                        x = new Point2D(bound.getMaxX(), bound.getMinY());
                        y = new Point2D(bound.getMaxX(), bound.getMaxY());
                        skip = center.getX() < bound.getMaxX();
                    }
                    break;
                case 1:
                    //right
                    if (checkRight) {
                        x = new Point2D(bound.getMinX(), bound.getMinY());
                        y = new Point2D(bound.getMinX(), bound.getMaxY());
                        skip = center.getX() > bound.getMinX();
                    }
                    break;
                case 2:
                    //up
                    if (checkUp) {
                        x = new Point2D(bound.getMinX(), bound.getMaxY());
                        y = new Point2D(bound.getMaxX(), bound.getMaxY());
                        skip = center.getY() < bound.getMaxY();
                    }
                    break;
                case 3:
                    if (checkDown) {
                        x = new Point2D(bound.getMinX(), bound.getMinY());
                        y = new Point2D(bound.getMaxX(), bound.getMinY());
                        skip = center.getY() > bound.getMinY();
                    }
                    break;
                case 4:
                    collide = true;//todo check this
                    x = new Point2D(0, 0);
                    y = new Point2D(0, 0);
                    break;
            }
            if (!skip) {
                double distance = getDistance(x, y, center);
                collide = collide || (distance < circle.getRadius());
            } else collide = false;
        }
        return collide;
    }
}
