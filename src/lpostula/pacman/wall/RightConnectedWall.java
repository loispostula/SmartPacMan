package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe RightConnectedWall
 */
public class RightConnectedWall extends RectangleWall {

    public RightConnectedWall(double dimension) {
        super(dimension);
        xBoundMin = wallIncrement;
        xBoundMax = wallDimension;
        yBoundMin = wallIncrement;
        yBoundMax = wallIncrement + wallWidth;
        constructCanva();
    }
}
