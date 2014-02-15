package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe VerticalConnectedWall
 */
public class VerticalConnectedWall extends RectangleWall {

    public VerticalConnectedWall(double dimension) {
        super(dimension);
        xBoundMin = wallIncrement;
        xBoundMax = wallIncrement + wallWidth;
        yBoundMin = 0.0;
        yBoundMax = wallDimension;
        checkLeft = checkRight = false;
        constructCanva();
    }
}
