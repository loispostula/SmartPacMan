package lpostula.pacman;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lpostula.gameengine.Sprite;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe PacMan
 */
public class PacMan extends Sprite {
    public static final int PACMAN_DIMENSION = 7;
    public static final Double PACMAN_SPEED_FACTOR = 3.0;
    private int direction = 0;
    private int forbid = 4;

    public PacMan() {
        Circle sphere = new Circle(PACMAN_DIMENSION);
        sphere.setFill(Color.YELLOW);
        sphere.setVisible(true);
        node = sphere;
        this.vX = this.vY = PACMAN_DIMENSION / PACMAN_SPEED_FACTOR;
    }

    @Override
    public void update() {
        int modX = 0;
        int modY = 0;
        switch (direction) {
            case 0:
                modX = -1;
                modY = 0;
                break;

            case 1:
                modX = 1;
                modY = 0;
                break;

            case 2:
                modX = 0;
                modY = -1;
                break;

            case 3:
                modX = 0;
                modY = 1;
                break;
            case 4:
                modX = 0;
                modY = 0;
                break;
        }
        node.setTranslateX(node.getTranslateX() + (modX * vX));
        node.setTranslateY(node.getTranslateY() + (modY * vY));
    }

    @Override
    public boolean collide(Sprite other) {

        return false;
    }

    public void move(KeyCode code) {
        boolean changeForbid = false;
        if (code.equals(KeyCode.LEFT)) {
            if (forbid != 0) {
                direction = 0;
                forbid = 4;
            }
        } else if (code.equals(KeyCode.RIGHT)) {
            if (forbid != 1) {
                direction = 1;
                forbid = 4;
            }
        } else if (code.equals(KeyCode.UP)) {
            if (forbid != 2) {
                direction = 2;
                forbid = 4;
            }
        } else if (code.equals(KeyCode.DOWN)) {
            if (forbid != 3) {
                direction = 3;
                forbid = 4;
            }
        }
    }

    public void stop() {
        forbid = direction;
        direction = 4;
    }

    public int getDirection() {
        return direction;
    }
}
