package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe UpConnectedWall
 */
public class UpConnectedWall extends RectangleWall {

    public UpConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundMin = wallIncrement;
        xBoundMax = wallIncrement + wallWidth;
        yBoundMin = 0.0;
        yBoundMax = wallIncrement + wallWidth;
        checkUp = false;
        constructCanva();
    }
}
