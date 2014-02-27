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
 * Documentation de la classe UpRightConnectedWall
 */
public class UpRightConnectedWall extends CornerWall {
    /**
     * Instantiates a new Up right connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public UpRightConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);

        xBoundMinMain = wallIncrement;
        xBoundMaxMain = wallDimension;

        xBoundMinSmall = wallIncrement;
        xBoundMaxSmall = wallIncrement + wallWidth;

        yBoundMinMain = wallIncrement;
        yBoundMaxMain = wallIncrement + wallWidth;

        yBoundMinSmall = 0.0;
        yBoundMaxSmall = wallIncrement;

        constructCanva();
        checkDown = checkRight = false;
    }

    @Override
    public void constructLine() {
        double mainMinX = xBoundMinMain + posX;
        double mainMinY = yBoundMinMain + posY;
        double mainMaxX = mainMinX + widthMain;
        double mainMaxY = mainMinY + heightMain;
        double smallMinX = xBoundMinSmall + posX;
        double smallMinY = yBoundMinSmall + posY;
        double smallMaxX = xBoundMaxSmall + posX;
        double smallMaxY = yBoundMaxSmall + posY;
        lineDown.add(new Line(mainMinX, mainMaxY, mainMaxX, mainMaxY));
        lineLeft.add(new Line(mainMinX, smallMinY, mainMinX, mainMaxY));
        lineRight.add(new Line(smallMaxX, smallMinY, smallMaxX, smallMaxY));
        lineUp.add(new Line(smallMaxX, smallMaxY, mainMaxX, smallMaxY));
    }
}
