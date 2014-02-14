package lpostula.pacman.wall;

import lpostula.gameengine.Sprite;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe Wall
 */
public abstract class Wall extends Sprite {
    protected double wallDimension;

    public Wall(double dimension) {
        //we will draw the path of every wall
        wallDimension = dimension;
    }

    @Override
    public void update() {

    }
}
