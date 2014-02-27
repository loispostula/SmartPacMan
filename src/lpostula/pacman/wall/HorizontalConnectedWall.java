package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe HorizontalConnectedWall
 */
public class HorizontalConnectedWall extends RectangleWall {

    /**
     * Instantiates a new Horizontal connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public HorizontalConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundMin = 0.0;
        xBoundMax = wallDimension;
        yBoundMin = wallIncrement;
        yBoundMax = wallIncrement + wallWidth;
        checkLeft = checkRight = false;
        constructCanva();
    }
}
