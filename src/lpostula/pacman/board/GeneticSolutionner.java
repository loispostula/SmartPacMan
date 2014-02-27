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

import lpostula.pacman.genetic.Population;

import java.util.LinkedList;

/**
 * Created by lpostula on 24/02/14.
 * Documentation de la classe GeneticSolutionner
 */
public class GeneticSolutionner extends Solutionner {

    private Point start;
    private Point prec;
    private Point enemy;

    /**
     * Instantiates a new Genetic solutionner.
     *
     * @param board the board
     * @param start the start
     * @param prec  the prec
     * @param enemy the enemy
     */
    public GeneticSolutionner(Board board, Point start, Point prec, Point enemy) {
        super(board);
        this.start = start;
        this.prec = prec;
        this.enemy = enemy;
    }

    @Override
    public void run() {
        path = new LinkedList<>();
        Population p = new Population(board.getBoard(), start, prec, enemy);
        do {
            try {
                p.nextGeneration();
            } catch (Exception e) {
                System.out.println("Exception : " + e.getMessage());
            }
        } while (p.getGeneration() < 500 && p.getAverageDiversity() > 0.0005);
        for (byte gene : p.getFitest().getGenome()) {
            path.add(new Integer(gene));
        }
    }
}
