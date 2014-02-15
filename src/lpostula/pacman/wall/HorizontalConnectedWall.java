package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe HorizontalConnectedWall
 */
public class HorizontalConnectedWall extends RectangleWall {

    public HorizontalConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundMin = 0.0;
        xBoundMax = wallDimension;
        yBoundMin = wallIncrement;
        yBoundMax = wallIncrement + wallWidth;
        checkLeft = checkRight = false;
        constructCanva();
    }
}
