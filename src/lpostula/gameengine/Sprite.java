package lpostula.gameengine;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe Sprite
 */
public abstract class Sprite {
    protected List animations = new ArrayList<>();
    protected Node node;
    protected double vX;
    protected double vY;
    protected boolean isDead = false;
    public abstract void update();
    public boolean collide(Sprite other){
        return false;
    }



}
