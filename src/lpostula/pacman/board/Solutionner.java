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

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Solutionner
 */
public abstract class Solutionner {
    /**
     * The Board.
     */
    protected Board board;

    /**
     * Gets path.
     *
     * @return the path
     */
    public List<Integer> getPath() {
        return path;
    }

    /**
     * The Path.
     */
    protected LinkedList<Integer> path = new LinkedList<>();

    /**
     * Instantiates a new Solutionner.
     *
     * @param board the board
     */
    public Solutionner(Board board) {
        this.board = board;
    }

    /**
     * Run void.
     */
    public abstract void run();
}
