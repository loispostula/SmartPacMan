package lpostula.pacman.genetic;

import lpostula.pacman.board.Point;

import java.util.ArrayList;

/**
 * Created by lpostula on 24/02/14.
 * Documentation de la classe Population
 */
public class Population {
    /**
     * The constant NMB_VILLAGE.
     */
    public static final int NMB_VILLAGE = 23;
    /**
     * The constant VILLAGE_SIZE.
     */
    public static final int VILLAGE_SIZE = 5;
    private ArrayList<Village> villages = new ArrayList<>();
    private int generation = 0;
    private double averageScore;
    private double averageDiversity;
    private Individual fitest;
    private int[][] maze;
    private Point start;
    private Point prec;
    private Point enemy;

    /**
     * Instantiates a new Population.
     *
     * @param maze  the maze
     * @param start the start
     * @param prec  the prec
     * @param enemy the enemy
     */
    public Population(int[][] maze, Point start, Point prec, Point enemy) {
        this.maze = maze;
        this.start = start;
        this.prec = prec;
        this.enemy = enemy;
        for (int i = 0; i < NMB_VILLAGE; ++i) {
            villages.add(new Village(VILLAGE_SIZE, maze, start, prec, enemy));
        }
    }

    /**
     * Get average diversity.
     *
     * @return the double
     */
    public double getAverageDiversity() {
        return averageDiversity;
    }

    /**
     * Get average score.
     *
     * @return the double
     */
    public double getAverageScore() {
        return averageScore;
    }

    /**
     * Gets generation.
     *
     * @return the generation
     */
    public int getGeneration() {
        return generation;
    }

    /**
     * Gets fitest.
     *
     * @return the fitest
     */
    public Individual getFitest() {
        return fitest;
    }

    /**
     * Compute stats.
     */
    public void ComputeStats() {
        averageScore = 0;
        averageDiversity = 0;
        for (Village v : villages) {
            averageScore += v.getAverageScore();
            averageDiversity += v.getAverageDiversity();
        }
        averageScore /= villages.size();
        averageDiversity /= villages.size();
    }

    /**
     * Next generation.
     *
     * @throws Exception the exception
     */
    public void nextGeneration() throws Exception {
        generation++;

        if (generation % 100 == 0 && villages.size() > 1) {
            ArrayList<Individual> villagers = new ArrayList<Individual>();
            for (Village v : villages) {
                villagers.addAll(v.getVillagers());
            }
            int nbVillage = villages.size() - 1;
            int villageSize = villagers.size() / nbVillage - 1;
            villages = new ArrayList<Village>();
            for (int i = 0; i < nbVillage; i++) {
                ArrayList<Individual> villPop = new ArrayList<Individual>();
                for (int j = i * villageSize; j < (i + 1) * villageSize; j++) {
                    villPop.add(villagers.get(j));
                }
                villages.add(new Village(villPop, maze, start, prec));
            }
        }
        Thread[] t = new Thread[villages.size()];
        int i = 0;
        for (Village v : villages) {
            t[i] = v.getThread();
            t[i].start();
            i++;
        }

        for (i = 0; i < t.length; i++) {
            t[i].join();
        }
        this.ComputeStats();
        Individual f = villages.get(0).getFitest();
        for (int ii = 1; ii < villages.size(); ii++) {
            if (f.getFitnessScore() < villages.get(ii).getFitest().getFitnessScore())
                f = villages.get(ii).getFitest();
        }
        this.fitest = (Individual) f.clone();
    }
}
