package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe LeftConnectedWall
 */
public class LeftConnectedWall extends RectangleWall {

    /**
     * Instantiates a new Left connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
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
