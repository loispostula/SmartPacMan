package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe SingleConnectedWall
 */
public abstract class SingleConnectedWall extends Wall {
    protected double xBoundMin;
    protected double xBoundMax;
    protected double yBoundMin;
    protected double yBoundMax;

    public SingleConnectedWall(double dimension) {
        super(dimension);
    }

    protected void constructCanva() {
        double[] pointsX = {
                xBoundMin,
                xBoundMin,
                xBoundMax,
                xBoundMax
        };
        double[] pointsY = {
                yBoundMin,
                yBoundMax,
                yBoundMax,
                yBoundMin
        };
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().fillPolygon(pointsX, pointsY, 4);
        node = canva;
        node.setVisible(true);
    }
}
