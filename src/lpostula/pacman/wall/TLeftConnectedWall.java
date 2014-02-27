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
 * Documentation de la classe TLeftConnectedWall
 */
public class TLeftConnectedWall extends TConnectedWall {
    /**
     * Instantiates a new T left connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public TLeftConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        xBoundBig = wallIncrement;
        yBoundBig = 0.0;
        widthBig = wallWidth;
        heightBig = wallDimension;

        xBoundSmall = 0.0;
        yBoundSmall = wallIncrement;
        widthSmall = wallIncrement;
        heightSmall = wallWidth;
        constructCanva();
    }

    @Override
    public void constructLine() {
        double xBoundBigCor = xBoundBig + posX;
        double yBoundBigCor = yBoundBig + posY;
        double xBoundSmallCor = xBoundSmall + posX;
        double yBoundSmallCor = yBoundSmall + posY;
        lineRight.add(new Line(xBoundBigCor + widthBig, yBoundBigCor, xBoundBigCor + widthBig, yBoundBigCor + heightBig));
        lineLeft.add(new Line(xBoundBigCor, yBoundBigCor, xBoundBigCor, yBoundSmallCor));
        lineLeft.add(new Line(xBoundBigCor, yBoundSmallCor + heightSmall, xBoundBigCor, yBoundBigCor + heightBig));
        lineUp.add(new Line(xBoundSmallCor, yBoundSmallCor, xBoundSmallCor + widthSmall, yBoundSmallCor));
        lineDown.add(new Line(xBoundSmallCor, yBoundSmallCor + heightSmall, xBoundSmallCor + widthSmall, yBoundSmallCor + heightSmall));


    }
}
