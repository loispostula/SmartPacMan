package lpostula.pacman.mobs;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lpostula.gameengine.Sprite;
import lpostula.pacman.board.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe PacMan
 */
public class PacMan extends Sprite {
    public static final int PACMAN_DIMENSION = 7;
    public static final double PACMAN_SPEED_FACTOR = 3.0;
    private int direction = 4;
    private int forbid = 4;
    private Board board;
    private boolean auto = false;
    private int step = 0;
    private List<Integer> path = new ArrayList<>();

    public PacMan(Board board) {
        this.board = board;
        Circle sphere = new Circle(PACMAN_DIMENSION);
        sphere.setFill(Color.YELLOW);
        sphere.setVisible(true);
        node = sphere;
        this.vX = this.vY = PACMAN_DIMENSION / PACMAN_SPEED_FACTOR;
        if (board != null) {
            auto = true;
            path = board.getSolution();
            this.vX = this.vY = board.getStepSize() / 10.0;
        }
    }

    @Override
    public void update() {
        if (auto) {
            if (step / 10 < path.size()) {
                if (step % 10 == 0) {
                    int ind = step / 10;
                    direction = path.get(ind);
                }
                ++step;
            } else direction = 4;
        }
        int modX = 0;
        int modY = 0;
        switch (direction) {

            case 0:
                modX = 0;
                modY = -1;
                break;
            case 1:
                modX = -1;
                modY = 0;
                break;

            case 2:
                modX = 1;
                modY = 0;
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
        if (code.equals(KeyCode.UP)) {
            if (forbid != 2) {
                direction = 0;
                forbid = 4;
            }
        } else if (code.equals(KeyCode.RIGHT)) {
            if (forbid != 1) {
                direction = 2;
                forbid = 4;
            }
        } else if (code.equals(KeyCode.LEFT)) {
            if (forbid != 0) {
                direction = 1;
                forbid = 4;
            }
        } else if (code.equals(KeyCode.DOWN))

        {
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
