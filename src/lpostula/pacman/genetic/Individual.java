package lpostula.pacman.genetic;

import lpostula.pacman.board.Point;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lpostula on 24/02/14.
 * Documentation de la classe Individual
 */
public class Individual implements Cloneable {
    /**
     * The constant UP.
     */
    public static final byte UP = 0;
    /**
     * The constant LEFT.
     */
    public static final byte LEFT = 1;
    /**
     * The constant RIGHT.
     */
    public static final byte RIGHT = 2;
    /**
     * The constant DOWN.
     */
    public static final byte DOWN = 3;
    private static final Random rand = new Random();

    private byte[] genome;

    /**
     * Gets path.
     *
     * @return the path
     */
    public ArrayList<Point> getPath() {
        return path;
    }

    private ArrayList<Point> path;
    private int[][] maze;
    private Point start;
    private Point prec;
    private Point enemy;
    private int size;
    private int powerballEaten = 0;

    /**
     * Instantiates a new Individual.
     *
     * @param genome the genome
     * @param maze   the maze
     * @param start  the start
     * @param prec   the prec
     * @param enemy  the enemy
     */
    public Individual(byte[] genome, int[][] maze, Point start, Point prec, Point enemy) {
        size = 19 * 21;
        this.genome = genome;
        this.maze = maze;
        this.start = start;
        this.prec = prec;
        this.enemy = enemy;
        computePath();
    }

    private void computePath() {
        PathCalculator calcul = new PathCalculator();
        calcul.compute(0, start);
    }

    /**
     * Gets random direction.
     *
     * @return the random direction
     */
    protected static byte getRandomDirection() {
        int v = rand.nextInt(4);
        if (v == 0)
            return UP;
        else if (v == 1)
            return LEFT;
        else if (v == 2)
            return RIGHT;
        else if (v == 3)
            return DOWN;
        return UP;
    }

    /**
     * Fill blank.
     *
     * @param genome the genome
     * @param start  the start
     * @return the byte [ ]
     */
    public static byte[] fillBlank(byte[] genome, int start) {
        for (int i = start; i < genome.length; i++) {
            genome[i] = Individual.getRandomDirection();
        }
        return genome;
    }

    /**
     * Gets fitness score.
     *
     * @return the fitness score
     */
    public double getFitnessScore() {
        FitnessBehaviour fitnessBehaviour = new FitnessBehaviour();
        this.computePath();
        return fitnessBehaviour.computeFitness(path, powerballEaten, maze, prec, enemy);
    }

    /**
     * Cross individual [ ].
     *
     * @param mother the mother
     * @return the individual [ ]
     */
    public Individual[] cross(Individual mother) {
        CrossBehaviour crossBehaviour = new CrossBehaviour();
        byte[][] childrenGenome = crossBehaviour.cross(this, mother, maze);
        Individual[] children = new Individual[2];
        children[0] = new Individual(childrenGenome[0], maze, start, prec, enemy);
        children[1] = new Individual(childrenGenome[1], maze, start, prec, enemy);
        return children;
    }

    /**
     * Mutate void.
     *
     * @throws Exception the exception
     */
    public void mutate() throws Exception {
        MutateBehaviour behaviour = new MutateBehaviour();
        genome = behaviour.mutate(genome);
        this.computePath();
    }

    /**
     * Improve void.
     *
     * @throws Exception the exception
     */
    public void improve() throws Exception {
        ImprovementBehaviour behaviour = new ImprovementBehaviour();
        genome = behaviour.improve(this);
        this.computePath();
    }

    /**
     * Get genome.
     *
     * @return the byte [ ]
     */
    public byte[] getGenome() {
        return genome;
    }

    /**
     * Gets diversity.
     *
     * @param mother the mother
     * @return the diversity
     */
    public double getDiversity(Individual mother) {
        int k = 0;
        byte[] g2 = mother.getGenome();
        for (int i = 0; i < size; i++) {
            if (genome[i] != g2[i])
                k++;
        }
        return ((double) k) / ((double) size);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Individual(genome, maze, start, prec, enemy);
    }

    /**
     * Gets powerball eaten.
     *
     * @return the powerball eaten
     */
    public int getPowerballEaten() {
        return powerballEaten;
    }

    private class PathCalculator {
        private int currentPosition;

        /**
         * Instantiates a new Path calculator.
         */
        public PathCalculator() {
            path = new ArrayList<Point>();
        }

        private void compute(int iteration, Point current) {
            if (iteration >= genome.length) {
                return;
            }
            if (maze[current.x][current.y] == 0) {
                ++powerballEaten;
            }
            byte gene = genome[iteration++];
            Point next = null;
            if (gene == LEFT) {
                try {
                    if (maze[current.x - 1][current.y] != 1) next = new Point(current.x - 1, current.y, null);
                    else return;
                } catch (Exception e) {
                    return;
                }
            } else if (gene == RIGHT) {
                try {
                    if (maze[current.x + 1][current.y] != 1) next = new Point(current.x + 1, current.y, null);
                    else return;
                } catch (Exception e) {
                    return;
                }
            } else if (gene == UP) {
                try {
                    if (maze[current.x][current.y - 1] != 1) next = new Point(current.x, current.y - 1, null);
                    else return;
                } catch (Exception e) {
                    return;
                }
            } else if (gene == DOWN) {
                try {
                    if (maze[current.x][current.y + 1] != 1) next = new Point(current.x, current.y + 1, null);
                    else return;
                } catch (Exception e) {
                    return;
                }
            }
            if (next != null) {
                path.add(next);
            } else return;
            compute(iteration, next);
        }
    }


}
