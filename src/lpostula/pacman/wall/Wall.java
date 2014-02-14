package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;
import lpostula.gameengine.Sprite;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe Wall
 */
public abstract class Wall extends Sprite {
    protected double wallDimension;
    protected Canvas canva;
    protected double wallWidth;
    protected double wallIncrement;

    public Wall(double dimension) {
        //we will draw the path of every wall
        wallDimension = dimension;
        wallWidth = wallDimension / 2.0;
        wallIncrement = wallWidth / 2.0;
    }

    @Override
    public void update() {

    }
}
