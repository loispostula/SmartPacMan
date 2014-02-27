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
 * Created by lpostula on 16/02/14.
 * Documentation de la classe TConnectedWall
 */
public class TConnectedWall extends Wall {
    /**
     * The X bound big.
     */
    protected double xBoundBig;
    /**
     * The Y bound big.
     */
    protected double yBoundBig;
    /**
     * The X bound small.
     */
    protected double xBoundSmall;
    /**
     * The Y bound small.
     */
    protected double yBoundSmall;
    /**
     * The Width big.
     */
    protected double widthBig;
    /**
     * The Height big.
     */
    protected double heightBig;
    /**
     * The Width small.
     */
    protected double widthSmall;
    /**
     * The Height small.
     */
    protected double heightSmall;

    /**
     * Instantiates a new T connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public TConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
    }

    /**
     * Construct canva.
     */
    public void constructCanva() {
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().setFill(COLOR);
        canva.getGraphicsContext2D().fillRect(xBoundBig, yBoundBig, widthBig, heightBig);
        canva.getGraphicsContext2D().fillRect(xBoundSmall, yBoundSmall, widthSmall, heightSmall);
        node = canva;
        node.setVisible(true);
        constructLine();
    }
}
