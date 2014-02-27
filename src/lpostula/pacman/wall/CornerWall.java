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

package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;

/**
 * Created by lpostula on 15/02/14.
 * Documentation de la classe CornerWall
 */
public class CornerWall extends Wall {
    /**
     * The X bound min main.
     */
    protected double xBoundMinMain;
    /**
     * The X bound max main.
     */
    protected double xBoundMaxMain;
    /**
     * The Y bound min main.
     */
    protected double yBoundMinMain;
    /**
     * The Y bound max main.
     */
    protected double yBoundMaxMain;

    /**
     * The X bound min small.
     */
    protected double xBoundMinSmall;
    /**
     * The X bound max small.
     */
    protected double xBoundMaxSmall;
    /**
     * The Y bound min small.
     */
    protected double yBoundMinSmall;
    /**
     * The Y bound max small.
     */
    protected double yBoundMaxSmall;

    /**
     * The Check left.
     */
    protected boolean checkLeft = true;
    /**
     * The Check right.
     */
    protected boolean checkRight = true;
    /**
     * The Check up.
     */
    protected boolean checkUp = true;
    /**
     * The Check down.
     */
    protected boolean checkDown = true;


    /**
     * The Width main.
     */
    protected double widthMain;
    /**
     * The Height main.
     */
    protected double heightMain;
    /**
     * The Width small.
     */
    protected double widthSmall;
    /**
     * The Height small.
     */
    protected double heightSmall;

    /**
     * Instantiates a new Corner wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public CornerWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
    }

    /**
     * Construct canva.
     */
    protected void constructCanva() {
        widthMain = xBoundMaxMain - xBoundMinMain;
        widthSmall = xBoundMaxSmall - xBoundMinSmall;
        heightMain = yBoundMaxMain - yBoundMinMain;
        heightSmall = yBoundMaxSmall - yBoundMinSmall;
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().setFill(COLOR);
        canva.getGraphicsContext2D().fillRect(xBoundMinMain, yBoundMinMain, widthMain, heightMain);
        canva.getGraphicsContext2D().fillRect(xBoundMinSmall, yBoundMinSmall, widthSmall, heightSmall);
        node = canva;
        node.setVisible(true);
        constructLine();
    }
}
