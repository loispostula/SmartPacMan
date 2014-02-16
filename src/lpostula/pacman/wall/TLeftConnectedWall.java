package lpostula.pacman.wall;

import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe TLeftConnectedWall
 */
public class TLeftConnectedWall extends TConnectedWall {
    public TLeftConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundBig = wallIncrement;
        yBoundBig = 0.0;
        widthBig = wallWidth;
        heightBig = wallDimension;

        xBoundSmall = 0.0;
        yBoundSmall = wallIncrement;
        widthSmall = wallIncrement;
        heightSmall = wallWidth;
        constructCanva();
    }

    @Override
    public void constructLine() {
        double xBoundBigCor = xBoundBig + posX;
        double yBoundBigCor = yBoundBig + posY;
        double xBoundSmallCor = xBoundSmall + posX;
        double yBoundSmallCor = yBoundSmall + posY;
        lineRight.add(new Line(xBoundBigCor + widthBig, yBoundBigCor, xBoundBigCor + widthBig, yBoundBigCor + heightBig));
        lineLeft.add(new Line(xBoundBigCor, yBoundBigCor, xBoundBigCor, yBoundSmallCor));
        lineLeft.add(new Line(xBoundBigCor, yBoundSmallCor + heightSmall, xBoundBigCor, yBoundBigCor + heightBig));
        lineUp.add(new Line(xBoundSmallCor, yBoundSmallCor, xBoundSmallCor + widthSmall, yBoundSmallCor));
        lineDown.add(new Line(xBoundSmallCor, yBoundSmallCor + heightSmall, xBoundSmallCor + widthSmall, yBoundSmallCor + heightSmall));


    }
}
