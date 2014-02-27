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

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe WallFactory
 */
public class WallFactory {
    /**
     * Build wall.
     *
     * @param position  the position
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     * @return the wall
     */
    public static Wall buildWall(WallPosition position, double dimension, double posX, double posY) {
        Wall wall = null;
        if (position != null) {
            switch (position) {
                case LEFT:
                    wall = new LeftConnectedWall(dimension, posX, posY);
                    break;
                case RIGHT:
                    wall = new RightConnectedWall(dimension, posX, posY);
                    break;
                case UP:
                    wall = new UpConnectedWall(dimension, posX, posY);
                    break;
                case DOWN:
                    wall = new DownConnectedWall(dimension, posX, posY);
                    break;
                case HORIZONTAL:
                    wall = new HorizontalConnectedWall(dimension, posX, posY);
                    break;
                case VERTICAL:
                    wall = new VerticalConnectedWall(dimension, posX, posY);
                    break;
                case CROSS:
                    wall = new CrossConnectedWall(dimension, posX, posY);
                    break;
                case CORNERUPLEFT:
                    wall = new UpLeftConnectedWall(dimension, posX, posY);
                    break;
                case CORNERUPRIGHT:
                    wall = new UpRightConnectedWall(dimension, posX, posY);
                    break;
                case CORNERDOWNLEFT:
                    wall = new DownLeftConnectedWall(dimension, posX, posY);
                    break;
                case CORNERDOWNRIGHT:
                    wall = new DownRightConnectedWall(dimension, posX, posY);
                    break;
                case TLEFT:
                    wall = new TLeftConnectedWall(dimension, posX, posY);
                    break;
                case TUP:
                    wall = new TUpConnectedWall(dimension, posX, posY);
                    break;
                case TRIGHT:
                    wall = new TRightConnectedWall(dimension, posX, posY);
                    break;
                case TDOWN:
                    wall = new TDownConnectedWall(dimension, posX, posY);
                    break;
            }
        }
        return wall;
    }
}
