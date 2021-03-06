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


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe PrimsBoard
 */
public class PrimsBoard extends Board {
    private static final int IN = 0;
    private static final int FRONTIER = 1;
    private static final int OUT = 2;
    private Random rand = new Random();

    /**
     * Instantiates a new Prims board.
     *
     * @param nX        the n x
     * @param nY        the n y
     * @param cellWidth the cell width
     * @param sX        the s x
     * @param sY        the s y
     */
    public PrimsBoard(int nX, int nY, double cellWidth, int sX, int sY) {
        super(nX, nY, cellWidth, sX, sY);

        // select random point and open as start node
        Point st = new Point(startX, startY, null);
        maze[st.x][st.y] = 2;

        // iterate through direct neighbors of node
        ArrayList<Point> frontier = new ArrayList<Point>();
        for (int i = -1; i <= 1; ++i)
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && j == 0 || i != 0 && j != 0)
                    continue;
                try {
                    if (maze[st.x + i][st.y + j] == 0) continue;
                } catch (Exception e) { // ignore ArrayIndexOutOfBounds
                    continue;
                }
                // add eligible points to frontier
                frontier.add(new Point(st.x + i, st.y + j, st));
            }

        Point last = null;
        while (!frontier.isEmpty()) {

            // pick current node at random
            Point cu = frontier.remove((int) (Math.random() * frontier.size()));
            Point op = cu.opposite();
            try {
                // if both node and its opposite are walls
                if (maze[cu.x][cu.y] == 1) {
                    if (maze[op.x][op.y] == 1) {

                        // open path between the nodes
                        maze[cu.x][cu.y] = 0;
                        maze[op.x][op.y] = 0;

                        // store last node in order to mark it later
                        last = op;

                        // iterate through direct neighbors of node, same as earlier
                        for (int i = -1; i <= 1; ++i)
                            for (int j = -1; j <= 1; ++j) {
                                if (i == 0 && j == 0 || i != 0 && j != 0)
                                    continue;
                                try {
                                    if (maze[op.x + i][op.y + j] == 0) continue;
                                } catch (Exception e) {
                                    continue;
                                }
                                frontier.add(new Point(op.x + i, op.y + j, op));
                            }
                    }
                }
            } catch (Exception e) { // ignore NullPointer and ArrayIndexOutOfBounds
            }

            // if algorithm has resolved, mark end node
            if (frontier.isEmpty()) {
                maze[last.x][last.y] = 3;
                this.endPoint = new Point(last.x, last.y, null);
            }
        }
    }
}
