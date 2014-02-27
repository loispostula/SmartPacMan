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


import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe TDownConnectedWall
 */
public class TDownConnectedWall extends TConnectedWall {

    /**
     * Instantiates a new T down connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public TDownConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundBig = 0.0;
        yBoundBig = wallIncrement;
        widthBig = wallDimension;
        heightBig = wallWidth;

        xBoundSmall = wallIncrement;
        yBoundSmall = wallIncrement + wallWidth;
        widthSmall = wallWidth;
        heightSmall = wallIncrement;
        constructCanva();
    }

    @Override
    public void constructLine() {
        double xBoundBigCor = xBoundBig + posX;
        double yBoundBigCor = yBoundBig + posY;
        double xBoundSmallCor = xBoundSmall + posX;
        double yBoundSmallCor = yBoundSmall + posY;
        lineUp.add(new Line(xBoundBigCor, yBoundBigCor, xBoundBigCor + widthBig, yBoundBigCor));
        lineDown.add(new Line(xBoundBigCor, yBoundBigCor + heightBig, xBoundSmallCor, yBoundBigCor + heightBig));
        lineDown.add(new Line(xBoundSmallCor + widthSmall, yBoundBigCor + heightBig, xBoundSmallCor + widthBig, yBoundBigCor + heightBig));
        lineLeft.add(new Line(xBoundSmallCor, yBoundSmallCor, xBoundSmallCor, yBoundSmallCor + heightSmall));
        lineRight.add(new Line(xBoundSmallCor + widthSmall, yBoundSmallCor, xBoundSmallCor + widthSmall, yBoundSmallCor + heightSmall));


    }
}
