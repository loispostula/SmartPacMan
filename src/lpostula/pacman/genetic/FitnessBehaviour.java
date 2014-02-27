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
        double factorA = 0;
        double factorB = 0;
        if (path.isEmpty()) return 0;
        Point pos = path.get(path.size() - 1);
        int x = pos.x;
        int y = pos.y;
        double distance = pos.getDistance(prec);
        factorA = 1 - (distance / Math.sqrt(maze.length * maze[0].length * 2.0));
        factorB = computeFactorB(path.size(), maze.length, maze[0].length);

        double distanceMob = 0;
        double factorC = 0;
        try {
            if (path.get(0).equals(prec)) return 0;
            distanceMob = path.get(0).getDistance(enemy);
        } catch (Exception e) {
            System.out.println(path);
        }
        factorC = distanceMob;
        double factorD = 1 / path.size();
        //return MOB_FACTOR * (1/ distance) + (1 - MOB_FACTOR) * factorC;
        double factorEaten = powerBallEaten;
        double factorWithMob = MOB_FACTOR * factorEaten + (1 - MOB_FACTOR) * factorC;
        double factorGlobal = PATH_LEN_FACTOR * factorWithMob + (1 - PATH_LEN_FACTOR) * factorD;
        return factorWithMob;
    }

    private double computeFactorB(double pathSize, double maseWidth, double maseHeigth) {
        double factorB = 0.0;
        double optiPathSize = maseWidth + maseHeigth - 1;
        double diff = optiPathSize - pathSize;

        double square = Math.pow(diff, 2);
        double max = Math.pow(optiPathSize, 2);
        factorB = (max - square) / max;
        return factorB;
    }
}
