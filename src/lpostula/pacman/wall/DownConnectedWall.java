package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe DownConnectedWall
 */
public class DownConnectedWall extends SingleConnectedWall {

    public DownConnectedWall(double dimension) {
        super(dimension);
        xBoundMin = wallIncrement;
        xBoundMax = wallIncrement + wallWidth;
        yBoundMin = wallIncrement;
        yBoundMax = wallDimension;
        constructCanva();
    }
}
