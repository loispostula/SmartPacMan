package lpostula.pacman.genetic;

import java.util.Random;

/**
 * Created by lpostula on 25/02/14.
 * Documentation de la classe CrossBehaviour
 */
public class CrossBehaviour {
    private static Random rand = new Random();

    /**
     * Cross byte [ ] [ ].
     *
     * @param father the father
     * @param mother the mother
     * @param maze   the maze
     * @return the byte [ ] [ ]
     */
    public byte[][] cross(Individual father, Individual mother, int[][] maze) {
        byte[] m = mother.getGenome();
        byte[] f = father.getGenome();
        byte[] child = new byte[maze.length * maze[0].length];
        byte[] child2 = new byte[maze.length * maze[0].length];


        for (int i = 0; i < child.length; i++) {
            int rd = rand.nextInt(2);
            if (rd == 0) {
                child[i] = m[i];
                child2[i] = f[i];
            } else {
                child[i] = f[i];
                child2[i] = m[i];
            }

        }
        byte[][] results = new byte[2][];
        results[0] = child;
        results[1] = child2;
        return results;
    }

}