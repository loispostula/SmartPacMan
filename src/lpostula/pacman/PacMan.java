package lpostula.pacman;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CircleBuilder;
import lpostula.gameengine.Sprite;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe PacMan
 */
public class PacMan extends Sprite {
    public static final int PACMAN_DIMENSION = 10;
    public static final Double PACMAN_SPEED_FACTOR = 3.5;
    private int direction = 0;

    public PacMan() {
        Circle sphere = CircleBuilder.create()
                .centerX(PACMAN_DIMENSION)
                .centerY(PACMAN_DIMENSION)
                .radius(PACMAN_DIMENSION)
                .cache(true)
                .build();
        sphere.setFill(Color.YELLOW);
        sphere.setTranslateX(200);
        sphere.setTranslateY(200);
        sphere.setVisible(true);
        sphere.setId("Pacman");
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

        }
        node.setTranslateX(node.getTranslateX() + (modX * vX));
        node.setTranslateY(node.getTranslateY() + (modY * vY));
    }

    @Override
    public boolean collide(Sprite other) {

        return false;
    }

    public void move(KeyCode code) {
        if (code.equals(KeyCode.LEFT)) {
            direction = 0;
        } else if (code.equals(KeyCode.RIGHT)) {
            direction = 1;
        } else if (code.equals(KeyCode.UP)) {
            direction = 2;
        } else if (code.equals(KeyCode.DOWN)) {
            direction = 3;
        }
    }
}
