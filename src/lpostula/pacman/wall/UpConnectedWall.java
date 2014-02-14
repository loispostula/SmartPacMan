package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe UpConnectedWall
 */
public class UpConnectedWall extends SingleConnectedWall {

    public UpConnectedWall(double dimension) {
        super(dimension);
        xBoundMin = wallIncrement;
        xBoundMax = wallIncrement + wallWidth;
        yBoundMin = 0.0;
        yBoundMax = wallIncrement + wallWidth;
        constructCanva();
    }
}
