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

import java.util.Random;

/**
 * Created by lpostula on 25/02/14.
 * Documentation de la classe MutateBehaviour
 */
public class MutateBehaviour {
    Random rand;

    public static final byte UP = 0;
    public static final byte LEFT = 1;
    public static final byte RIGTH = 2;
    public static final byte DOWN = 3;

    public MutateBehaviour() {
        rand = new Random();
    }

    /**
     * Mutate byte [ ].
     *
     * @param genome the genome
     * @return the byte [ ]
     */
    public byte[] mutate(byte[] genome) {
        byte[] temp = genome.clone();
        for (int i = 0; i < temp.length; i++) {
            if (rand.nextInt(1000) == 10) {
                int val = rand.nextInt(4);
                if (val == 0)
                    temp[i] = UP;
                else if (val == 1)
                    temp[i] = LEFT;
                else if (val == 2)
                    temp[i] = RIGTH;
                else if (val == 3)
                    temp[i] = DOWN;
            }
        }
        return temp;
    }

}
