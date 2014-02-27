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

package lpostula.pacman.genetic;

import lpostula.pacman.board.Point;

import java.util.ArrayList;

/**
 * Created by lpostula on 25/02/14.
 * Documentation de la classe FitnessBehavior
 */
public class FitnessBehaviour {

    /**
     * The constant ALPHA.
     */
    public static final double ALPHA = 0.50;
    /**
     * The constant MOB_FACTOR.
     */
    public static final double MOB_FACTOR = 0.2;
    /**
     * The constant PATH_LEN_FACTOR.
     */
    public static final double PATH_LEN_FACTOR = 0.95;


    /**
     * Compute fitness.
     *
     * @param path           the path
     * @param powerBallEaten the power ball eaten
     * @param maze           the maze
     * @param prec           the prec
     * @param enemy          the enemy
     * @return the double
     */
    public double computeFitness(ArrayList<Point> path, int powerBallEaten, int[][] maze, Point prec, Point enemy) {
        if (path.isEmpty()) return 0;
        double distanceMob = 0;
        try {
            if (path.get(0).equals(prec)) return 0;
            distanceMob = path.get(0).getDistance(enemy);
        } catch (Exception e) {
        }
        double factorC = distanceMob;
        double factorD = 1 / path.size();
        double factorEaten = powerBallEaten;
        double factorWithMob = MOB_FACTOR * factorEaten + (1 - MOB_FACTOR) * factorC;
        return factorWithMob;
    }
}
