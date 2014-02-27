package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe RightConnectedWall
 */
public class RightConnectedWall extends RectangleWall {

    /**
     * Instantiates a new Right connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public RightConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundMin = wallIncrement;
        xBoundMax = wallDimension;
        yBoundMin = wallIncrement;
        yBoundMax = wallIncrement + wallWidth;
        checkRight = false;
        constructCanva();
    }
}
