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

package lpostula.pacman.board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lpostula on 24/02/14.
 * Documentation de la classe CyclicBoard
 */
public class CyclicBoard extends Board {
    List<Pair> pairs = new ArrayList<>();

    /**
     * Instantiates a new Board.
     *
     * @param nX        the n x
     * @param nY        the n y
     * @param cellWidth the cell width
     * @param sX        the s x
     * @param sY        the s y
     */
    public CyclicBoard(int nX, int nY, double cellWidth, int sX, int sY) {
        super(nX, nY, cellWidth, sX, sY);

        //first we carve the wall
        for (int i = 0; i < nX; ++i) {
            for (int j = 0; j < nY; ++j) {
                maze[i][j] = 0;
            }
        }
        generatePairs();
        int i = 0;
        Collections.shuffle(pairs);
        while (i < pairs.size()) {
            Pair pair = pairs.get(i);
            maze[pair.i][pair.j] = 1;
            int xOrig = pair.horizontal ? pair.i - 1 : pair.i;
            int yOrig = pair.horizontal ? pair.i : pair.j - 1;

            if (getNmbWall(xOrig, yOrig) == 3) {
                maze[pair.i][pair.j] = 0;
                ++i;
            } else if (pair.horizontal) {
                if ((getNmbWall(xOrig + 2, yOrig) == 3) || !(isReachable(xOrig, yOrig, xOrig + 2, yOrig))) {
                    maze[pair.i][pair.j] = 0;
                    ++i;
                } else {
                    pairs.remove(pair);
                    Collections.shuffle(pairs);
                    i = 0;
                }
            } else {
                if ((getNmbWall(xOrig, yOrig + 2) == 3) || !(isReachable(xOrig, yOrig, xOrig, yOrig + 2))) {
                    maze[pair.i][pair.j] = 0;
                    ++i;
                } else {
                    pairs.remove(pair);
                    Collections.shuffle(pairs);
                    i = 0;
                }
            }
        }
    }

    private boolean isReachable(int xOrig, int yOrig, int xTarget, int yTarget) {
        RecursifSolutioner sol = new RecursifSolutioner(this, new Point(xOrig, yOrig, null), new Point(xTarget, yTarget, null));
        boolean reachable = sol.solved();
        return reachable;
    }

    /**
     * Generate pairs.
     */
    private void generatePairs() {
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (i % 2 == 0) {
                    if (j % 2 == 1) {
                        pairs.add(new Pair(i, j, false));
                    }
                } else pairs.add(new Pair(i, j, true));
            }
        }
    }

    /**
     * Get nmb wall.
     *
     * @param x the x
     * @param y the y
     * @return the int
     */
    private int getNmbWall(int x, int y) {
        int wall = 0;
        try {
            if (maze[x - 1][y] == 1) ++wall;
        } catch (Exception e) {
        }
        try {
            if (maze[x + 1][y] == 1) ++wall;
        } catch (Exception e) {
        }
        try {
            if (maze[x][y - 1] == 1) ++wall;
        } catch (Exception e) {
        }
        try {
            if (maze[x][y + 1] == 1) ++wall;
        } catch (Exception e) {
        }
        return wall;
    }

    private class Pair {
        /**
         * The I.
         */
        public int i;
        /**
         * The J.
         */
        public int j;

        /**
         * The Horizontal.
         */
        public boolean horizontal;

        /**
         * Instantiates a new Pairs.
         *
         * @param i   the i
         * @param j   the j
         * @param hor the hor
         */
        public Pair(int i, int j, boolean hor) {
            this.i = i;
            this.j = j;
            this.horizontal = hor;
        }
    }
}
