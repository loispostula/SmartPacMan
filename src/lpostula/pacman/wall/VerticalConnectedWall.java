package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe VerticalConnectedWall
 */
public class VerticalConnectedWall extends RectangleWall {

    /**
     * Instantiates a new Vertical connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public VerticalConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundMin = wallIncrement;
        xBoundMax = wallIncrement + wallWidth;
        yBoundMin = 0.0;
        yBoundMax = wallDimension;
        checkDown = checkUp = false;
        constructCanva();
    }
}
