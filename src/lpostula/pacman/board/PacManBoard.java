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

package lpostula.pacman.board;

/**
 * Created by lpostula on 24/02/14.
 * Documentation de la classe PacManBoard
 */
public class PacManBoard extends Board {
    /**
     * Instantiates a new Board.
     *
     * @param nX        the n x
     * @param nY        the n y
     * @param cellWidth the cell width
     * @param sX        the s x
     * @param sY        the s y
     */
    public PacManBoard(int nX, int nY, double cellWidth, int sX, int sY) {
        super(nX, nY, cellWidth, sX, sY);
        maze[0] = new int[]{1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        maze[1] = new int[]{1, 0, 0, 0, 0, 0, 1, -1, -1, -1, -1, -1, 1, 0, 0, 0, 1, 0, 0, 0, 1};
        maze[2] = new int[]{1, 0, 1, 0, 1, 0, 1, -1, -1, -1, -1, -1, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        maze[3] = new int[]{1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1};
        maze[4] = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1};
        maze[5] = new int[]{1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1};
        maze[6] = new int[]{1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1};
        maze[7] = new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        maze[8] = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, -1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1};
        maze[9] = new int[]{1, 1, 1, 0, 1, 1, 1, 0, -1, -1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1};
        maze[10] = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, -1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1};
        maze[11] = new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        maze[12] = new int[]{1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1};
        maze[13] = new int[]{1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1};
        maze[14] = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1};
        maze[15] = new int[]{1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1};
        maze[16] = new int[]{1, 0, 1, 0, 1, 0, 1, -1, -1, -1, -1, -1, 1, 0, 1, 0, 0, 0, 1, 0, 1};
        maze[17] = new int[]{1, 0, 0, 0, 0, 0, 1, -1, -1, -1, -1, -1, 1, 0, 0, 0, 1, 0, 0, 0, 1};
        maze[18] = new int[]{1, 1, 1, 1, 1, 1, 1, -1, -1, -1, -1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        endPoint = new Point(18, 9, null);
        startX = 0;
        startY = 9;
    }
}
