package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe LeftConnectedWall
 */
public class LeftConnectedWall extends RectangleWall {

    public LeftConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundMin = 0.0;
        xBoundMax = wallIncrement + wallWidth;
        yBoundMin = wallIncrement;
        yBoundMax = wallIncrement + wallWidth;
        checkLeft = false;
        constructCanva();
    }

}
