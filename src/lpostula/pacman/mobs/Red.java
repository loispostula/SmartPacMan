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

package lpostula.pacman.mobs;

import javafx.scene.paint.Color;
import lpostula.pacman.board.AStarSolutionner;
import lpostula.pacman.board.Board;

import java.util.ArrayList;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Red
 */
public class Red extends Hunter {
    AStarSolutionner solutionner;

    /**
     * Instantiates a new Red.
     *
     * @param board  the board
     * @param pacman the pacman
     */
    public Red(Board board, PacMan pacman) {
        super(board, pacman);
        MOB_COLOR = Color.RED;
        SPEED_FACTOR = 8.0;
        constructNode();
        solutionner = new AStarSolutionner(board);
        path = new ArrayList<Integer>();
    }

    @Override
    protected void computePath() {
        solutionner.setStart(getPosition().x, getPosition().y);
        solutionner.setEnd(target.getPos().x, target.getPos().y);
        solutionner.run();
        path = solutionner.getPath();
        //path = new ArrayList<>();
    }
}
