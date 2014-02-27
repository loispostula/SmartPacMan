package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe DownConnectedWall
 */
public class DownConnectedWall extends RectangleWall {

    /**
     * Instantiates a new Down connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public DownConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundMin = wallIncrement;
        xBoundMax = wallIncrement + wallWidth;
        yBoundMin = wallIncrement;
        yBoundMax = wallDimension;
        checkDown = false;
        constructCanva();
    }
}
