package lpostula.pacman.mobs;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import lpostula.gameengine.Sprite;

/**
 * Created by lpostula on 17/02/14.
 * Documentation de la classe PowerBall
 */
public class PowerBall extends Sprite {
    private static final Color COLOR = Color.BLUE;
    private static final int POWERBALL_DIMENSION = 2;
    private double dimension;
    private Canvas canva;

    public PowerBall(double size) {
        dimension = size;
        canva = new Canvas(dimension, dimension);
        double x = dimension / 2 - POWERBALL_DIMENSION / 2;
        canva.getGraphicsContext2D().setFill(COLOR);
        canva.getGraphicsContext2D().fillOval(x, x, POWERBALL_DIMENSION * 2, POWERBALL_DIMENSION * 2);
        node = canva;
    }

    @Override
    public void update() {

    }

    @Override
    public int getDirection() {
        return 0;
    }

    public void handleDeath() {
        isDead = true;
        canva.setVisible(false);
    }

    public boolean isDead() {
        return isDead;
    }
}
