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
import lpostula.pacman.board.Board;
import lpostula.pacman.board.RecursifSolutioner;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Red
 */
public class Blue extends Hunter {
    /**
     * Instantiates a new Blue.
     *
     * @param board  the board
     * @param pacman the pacman
     */
    public Blue(Board board, PacMan pacman) {
        super(board, pacman);
        MOB_COLOR = Color.BLUE;
        SPEED_FACTOR = 8.0;
        constructNode();
    }

    @Override
    protected void computePath() {
        RecursifSolutioner solutioner = new RecursifSolutioner(board, position, target.getPos());
        path = solutioner.getPath();
    }
}
