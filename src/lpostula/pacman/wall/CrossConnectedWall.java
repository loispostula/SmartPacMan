package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe CrossConnectedWall
 */
public class CrossConnectedWall extends Wall {
    /**
     * The X bound vert.
     */
    protected double xBoundVert;
    /**
     * The Y bound vert.
     */
    protected double yBoundVert;
    /**
     * The X bound hor.
     */
    protected double xBoundHor;
    /**
     * The Y bound hor.
     */
    protected double yBoundHor;
    /**
     * The Long dist.
     */
    protected double longDist;
    /**
     * The Short dist.
     */
    protected double shortDist;

    /**
     * Instantiates a new Cross connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public CrossConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundVert = wallIncrement;
        yBoundVert = 0.0;

        xBoundHor = 0.0;
        yBoundHor = wallIncrement;

        longDist = wallDimension;
        shortDist = wallWidth;
        constructCanva();
    }

    /**
     * Construct canva.
     */
    public void constructCanva() {
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().setFill(COLOR);
        canva.getGraphicsContext2D().fillRect(xBoundVert, yBoundVert, shortDist, longDist);
        canva.getGraphicsContext2D().fillRect(xBoundHor, yBoundHor, longDist, shortDist);
        node = canva;
        node.setVisible(true);
        constructLine();
    }

    @Override
    public void constructLine() {
        double xBoundHorCor = xBoundHor + posX;
        double xBoundVertCor = xBoundVert + posX;
        double yBoundHorCor = yBoundHor + posY;
        double yBoundVertCor = yBoundVert + posY;
        lineUp.add(new Line(xBoundHorCor, yBoundHorCor, xBoundVertCor, yBoundHorCor));
        lineUp.add(new Line(xBoundVertCor + shortDist, yBoundHorCor, xBoundHorCor + longDist, yBoundHorCor));
        lineDown.add(new Line(xBoundHorCor, yBoundHorCor + shortDist, xBoundVertCor, yBoundHorCor + shortDist));
        lineDown.add(new Line(xBoundVertCor + shortDist, yBoundHorCor + shortDist, xBoundHorCor + longDist, yBoundHorCor + shortDist));
        lineLeft.add(new Line(xBoundVertCor, yBoundVertCor, xBoundVertCor, yBoundHorCor));
        lineLeft.add(new Line(xBoundVertCor, yBoundHorCor + shortDist, xBoundVertCor, yBoundVertCor + longDist));
        lineRight.add(new Line(xBoundVertCor + shortDist, yBoundVertCor, xBoundVertCor + shortDist, yBoundHorCor));
        lineRight.add(new Line(xBoundVertCor + shortDist, yBoundHorCor + shortDist, xBoundVertCor + shortDist, yBoundVertCor + longDist));
    }
}
