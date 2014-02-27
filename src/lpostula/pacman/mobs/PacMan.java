/*
 * This file is part of SmartPacMan.
 *
 *     SmartPacMan is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     SmartPacMan is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with SmartPacMan.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of SmartPacMan.
 *
 *     SmartPacMan is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     SmartPacMan is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with SmartPacMan.  If not, see <http://www.gnu.org/licenses/>.
 */

package lpostula.pacman.mobs;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import lpostula.gameengine.Sprite;
import lpostula.pacman.board.Board;
import lpostula.pacman.board.GeneticSolutionner;
import lpostula.pacman.board.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe PacMan
 */
public class PacMan extends Sprite {
    /**
     * The constant PACMAN_DIMENSION.
     */
    public static final int PACMAN_DIMENSION = 7;
    /**
     * The constant PACMAN_SPEED_FACTOR.
     */
    public static final double PACMAN_SPEED_FACTOR = 8;
    private int direction = 4;
    private int forbid = 4;
    private Board board;
    private boolean auto = false;
    private int step = 0;
    private List<Integer> path = new ArrayList<>();
    private int score = 0;
    private Hunter red;
    private Point prec = new Point(-1, -1, null);

    /**
     * Instantiates a new Pac man.
     *
     * @param board       the board
     * @param automatique the automatique
     */
    public PacMan(Board board, boolean automatique) {
        this.board = board;
        Circle sphere = new Circle(PACMAN_DIMENSION);
        sphere.setFill(Color.YELLOW);
        sphere.setVisible(true);
        node = sphere;
        this.vX = this.vY = PACMAN_DIMENSION / PACMAN_SPEED_FACTOR;
        if (automatique) {
            auto = true;
            this.vX = this.vY = board.getStepSize() / PACMAN_SPEED_FACTOR;
        }
    }

    /**
     * Gets pos.
     *
     * @return the pos
     */
    public Point getPos() {
        int x = (int) Math.floor(node.getTranslateX() / board.getStepSize());
        int y = (int) Math.floor(node.getTranslateY() / board.getStepSize());
        return new Point(x, y, null);
    }

    /**
     * Sets red.
     *
     * @param red the red
     */
    public void setRed(Hunter red) {
        this.red = red;
    }

    private void computePath() {
        Point start = getPos();
        Point end = board.getEndPoint();
        Point enemy = red.getPosition();
        GeneticSolutionner solutionner = new GeneticSolutionner(board, start, prec, enemy);
        solutionner.run();
        path = solutionner.getPath();
    }

    @Override
    public void update() {
        if (step % PACMAN_SPEED_FACTOR == 0) {
            computePath();
            prec = getPos();
            direction = path.get(0);
            step = 0;
        }
        ++step;
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
            default:
                break;
        }
        node.setTranslateX(node.getTranslateX() + (modX * vX));
        node.setTranslateY(node.getTranslateY() + (modY * vY));
    }

    @Override
    public boolean collide(Sprite other) {
        boolean collided = false;
        if (other instanceof PowerBall) {
            if (!((PowerBall) other).isDead()) {
                double thisX = node.getTranslateX() / board.getStepSize();
                double thisY = node.getTranslateY() / board.getStepSize();

                double otherX = other.node.getTranslateX() / board.getStepSize();
                double otherY = other.node.getTranslateY() / board.getStepSize();

                if (thisX > otherX && thisX < otherX + 1 && thisY > otherY && thisY < otherY + 1) {
                    ++this.score;
                    collided = true;
                }
            }
        }
        return collided;
    }

    /**
     * Move void.
     *
     * @param code the code
     */
    public void move(KeyCode code) {
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

    /**
     * Stop void.
     */
    public void stop() {
        forbid = direction;
        direction = 4;
    }

    /**
     * Handle death.
     */
    public void handleDeath() {
        System.out.println(score);
    }

    @Override
    public int getDirection() {
        return direction;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Paint getColor() {
        return Color.YELLOW;
    }


    /**
     * Gets path.
     *
     * @return the path
     */
    public List<Integer> getPath() {
        return path;
    }
}
