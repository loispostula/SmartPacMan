package lpostula.pacman.wall;


import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe TDownConnectedWall
 */
public class TDownConnectedWall extends TConnectedWall {

    /**
     * Instantiates a new T down connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public TDownConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundBig = 0.0;
        yBoundBig = wallIncrement;
        widthBig = wallDimension;
        heightBig = wallWidth;

        xBoundSmall = wallIncrement;
        yBoundSmall = wallIncrement + wallWidth;
        widthSmall = wallWidth;
        heightSmall = wallIncrement;
        constructCanva();
    }

    @Override
    public void constructLine() {
        double xBoundBigCor = xBoundBig + posX;
        double yBoundBigCor = yBoundBig + posY;
        double xBoundSmallCor = xBoundSmall + posX;
        double yBoundSmallCor = yBoundSmall + posY;
        lineUp.add(new Line(xBoundBigCor, yBoundBigCor, xBoundBigCor + widthBig, yBoundBigCor));
        lineDown.add(new Line(xBoundBigCor, yBoundBigCor + heightBig, xBoundSmallCor, yBoundBigCor + heightBig));
        lineDown.add(new Line(xBoundSmallCor + widthSmall, yBoundBigCor + heightBig, xBoundSmallCor + widthBig, yBoundBigCor + heightBig));
        lineLeft.add(new Line(xBoundSmallCor, yBoundSmallCor, xBoundSmallCor, yBoundSmallCor + heightSmall));
        lineRight.add(new Line(xBoundSmallCor + widthSmall, yBoundSmallCor, xBoundSmallCor + widthSmall, yBoundSmallCor + heightSmall));


    }
}
