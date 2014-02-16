package lpostula.gameengine;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe Sprite
 */
public abstract class Sprite {
    public List animations = new ArrayList<>();
    public Node node;
    public double vX;
    public double vY;
    public boolean isDead = false;

    public abstract void update();

    public abstract int getDirection();

    public boolean collide(Sprite other) {
        return false;
    }


}
