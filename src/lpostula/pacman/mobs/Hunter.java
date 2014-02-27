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

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lpostula.gameengine.Sprite;
import lpostula.pacman.board.Board;
import lpostula.pacman.board.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Hunter
 */
public abstract class Hunter extends Sprite {
    /**
     * The constant DIMENSION.
     */
    public static final int DIMENSION = 7;
    /**
     * The SPEED _ fACTOR.
     */
    public double SPEED_FACTOR = 8;
    /**
     * The MOB _ cOLOR.
     */
    protected Color MOB_COLOR = Color.RED;
    private int direction = 4;
    /**
     * The Board.
     */
    protected Board board;
    private int step = 0;
    /**
     * The Path.
     */
    protected List<Integer> path = new ArrayList<>();
    /**
     * The Position.
     */
    protected Point position = new Point(-1, -1, null);
    /**
     * The Init pos for path.
     */
    protected Point initPosForPath = new Point(-1, -1, null);
    /**
     * The Target.
     */
    protected PacMan target;

    /**
     * Instantiates a new Hunter.
     *
     * @param board  the board
     * @param target the target
     */
    public Hunter(Board board, PacMan target) {
        this.board = board;
        this.vX = this.vY = board.getStepSize() / SPEED_FACTOR;
        this.target = target;

    }

    /**
     * Construct node.
     */
    protected void constructNode() {
        Circle sphere = new Circle(DIMENSION);
        sphere.setFill(MOB_COLOR);
        sphere.setVisible(true);
        node = sphere;

    }

    @Override
    public void update() {
        if (step % SPEED_FACTOR == 0) {
            computePath();
            if (path.size() > 0) {
                direction = path.get(0);
            }
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
        }
        node.setTranslateX(node.getTranslateX() + (modX * vX));
        node.setTranslateY(node.getTranslateY() + (modY * vY));
    }

    /**
     * Compute path.
     */
    protected abstract void computePath();

    @Override
    public int getDirection() {
        return direction;
    }

    @Override
    public boolean collide(Sprite other) {
        if (other instanceof PacMan) {
            Circle otherSphere = (Circle) other.node;
            Circle thisSphere = (Circle) node;
            Point2D otherCenter = otherSphere.localToScene(otherSphere.getCenterX(), otherSphere.getCenterY());
            Point2D thisCenter = thisSphere.localToScene(thisSphere.getCenterX(), thisSphere.getCenterY());
            double dx = otherCenter.getX() - thisCenter.getX();
            double dy = otherCenter.getY() - thisCenter.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
            double minDist = otherSphere.getRadius() + thisSphere.getRadius();
            return (distance < minDist);
        } else if (other instanceof Hunter) {
            return false;
        } else return other.collide(this);
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public List<Integer> getPath() {
        return path;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public Point getPosition() {
        int x = (int) Math.floor(node.getTranslateX() / board.getStepSize());
        int y = (int) Math.floor(node.getTranslateY() / board.getStepSize());
        return new Point(x, y, null);
    }

    /**
     * Gets init pos for path.
     *
     * @return the init pos for path
     */
    public Point getInitPosForPath() {
        return initPosForPath;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return MOB_COLOR;
    }

}
