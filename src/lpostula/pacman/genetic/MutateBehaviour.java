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
