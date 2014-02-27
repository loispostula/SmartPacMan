package lpostula.gameengine;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe Sprite
 */
public abstract class Sprite {
    /**
     * The Animations.
     */
    public List animations = new ArrayList<>();
    /**
     * The Node.
     */
    public Node node;
    /**
     * The V x.
     */
    public double vX;
    /**
     * The V y.
     */
    public double vY;
    /**
     * The Is dead.
     */
    public boolean isDead = false;

    /**
     * Update void.
     */
    public abstract void update();

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public abstract int getDirection();

    /**
     * Collide boolean.
     *
     * @param other the other
     * @return the boolean
     */
    public boolean collide(Sprite other) {
        return false;
    }


}
