package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe UpConnectedWall
 */
public class UpConnectedWall extends RectangleWall {

    /**
     * Instantiates a new Up connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
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
