package lpostula.pacman.wall;

import javafx.scene.shape.Circle;
import lpostula.gameengine.Sprite;
import lpostula.pacman.PacMan;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe LeftConnectedWall
 */
public class LeftConnectedWall extends RectangleWall {

    public LeftConnectedWall(double dimension) {
        super(dimension);
        xBoundMin = 0.0;
        xBoundMax = wallIncrement + wallWidth;
        yBoundMin = wallIncrement;
        yBoundMax = wallIncrement + wallWidth;
        constructCanva();
    }

    @Override
    public boolean collide(Sprite other) {
        boolean collide = false;
        if (other instanceof PacMan) {
            Circle circle = (Circle) other.node;

        }
        return collide;
    }
}
