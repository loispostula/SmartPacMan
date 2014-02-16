package lpostula.pacman.wall;


import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe TDownConnectedWall
 */
public class TUpConnectedWall extends TConnectedWall {

    public TUpConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundBig = 0.0;
        yBoundBig = wallIncrement;
        widthBig = wallDimension;
        heightBig = wallWidth;

        xBoundSmall = wallIncrement;
        yBoundSmall = 0.0;
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
        lineDown.add(new Line(xBoundBigCor, yBoundBigCor + heightBig, xBoundBigCor + widthBig, yBoundBigCor + heightBig));
        lineUp.add(new Line(xBoundBigCor, yBoundBigCor, xBoundSmallCor, yBoundBigCor));
        lineUp.add(new Line(xBoundSmallCor + widthSmall, yBoundBigCor, xBoundSmallCor + widthBig, yBoundBigCor));
        lineLeft.add(new Line(xBoundSmallCor, yBoundSmallCor, xBoundSmallCor, yBoundSmallCor + heightSmall));
        lineRight.add(new Line(xBoundSmallCor + widthSmall, yBoundSmallCor, xBoundSmallCor + widthSmall, yBoundSmallCor + heightSmall));


    }
}
