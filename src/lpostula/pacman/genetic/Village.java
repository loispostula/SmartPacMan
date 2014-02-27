package lpostula.pacman.genetic;

import lpostula.pacman.board.Point;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lpostula on 24/02/14.
 * Documentation de la classe Village
 */
public class Village {
    private ArrayList<Individual> villagers = new ArrayList<>();
    private int size;
    private double averageScore;
    private double averageDiversity;
    private static final Random rand = new Random();
    private Individual fitest;

    private int[][] maze;
    private Point start;
    private Point prec;
    private Point enemy;

    /**
     * Instantiates a new Village.
     *
     * @param size  the size
     * @param maze  the maze
     * @param start the start
     * @param prec  the prec
     * @param enemy the enemy
     */
    public Village(int size, int[][] maze, Point start, Point prec, Point enemy) {
        this.size = size;
        this.maze = maze;
        this.start = start;
        this.prec = prec;
        this.enemy = enemy;
        for (int i = 0; i < size; ++i) {
            byte[] genome = Individual.fillBlank(new byte[19 * 21], 0);
            villagers.add(new Individual(genome, maze, start, prec, enemy));
        }
    }

    /**
     * Instantiates a new Village.
     *
     * @param villagers the villagers
     * @param maze      the maze
     * @param start     the start
     * @param prec      the prec
     */
    public Village(ArrayList<Individual> villagers, int[][] maze, Point start, Point prec) {
        this.villagers = villagers;
        this.size = size;
        this.maze = maze;
        this.start = start;
        this.prec = prec;
    }

    /**
     * Get fitest.
     *
     * @return the individual
     */
    public Individual getFitest() {
        return fitest;
    }

    /**
     * Get size.
     *
     * @return the int
     */
    public int getSize() {
        return size;
    }

    /**
     * Get villagers.
     *
     * @return the array list
     */
    public ArrayList<Individual> getVillagers() {
        return villagers;
    }

    /**
     * Set villages.
     *
     * @param v the v
     */
    public void setVillages(ArrayList<Individual> v) {
        villagers = v;
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
     * Get average diversity.
     *
     * @return the double
     */
    public double getAverageDiversity() {
        return averageDiversity;
    }

    /**
     * Compute stats.
     */
    public void computeStats() {
        int nbScore = 0;
        int nbDiv = 0;
        averageScore = 0;
        averageDiversity = 0;
        for (int i = 0; i < size; i++) {
            double fitnessScore = villagers.get(i).getFitnessScore();
            averageScore += fitnessScore;
            nbScore++;
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    averageDiversity += villagers.get(i).getDiversity(villagers.get(j));
                    nbDiv++;
                }
            }
        }
        averageDiversity /= nbDiv;
        averageScore /= nbScore;
    }

    /**
     * Get thread.
     *
     * @return the thread
     */
    public Thread getThread() {
        return new NextGenerationThread(this);
    }

    private class NextGenerationThread extends Thread {
        private Village village;

        /**
         * Instantiates a new Next generation thread.
         *
         * @param v the v
         */
        public NextGenerationThread(Village v) {
            village = v;
        }

        @Override
        public void run() {
            village.computeStats();
            ArrayList<Individual> strongers = this.eliminWeakest();

            ArrayList<Individual> newPop = new ArrayList<Individual>();
            Object[] individuals = strongers.toArray();
            Sort.QuickSort(individuals);
            fitest = (Individual) individuals[0];
            newPop.add(fitest);
            for (int j = 0; j < individuals.length; j++) {
                Individual[] children = this.cross((Individual) individuals[j], village.getVillagers());
                newPop.add(children[0]);
                newPop.add(children[1]);
                if (j < individuals.length / 2) {
                    children = this.cross((Individual) individuals[j], village.getVillagers());
                    newPop.add(children[0]);
                    newPop.add(children[1]);
                }
                if (j < individuals.length / 3) {
                    children = this.cross((Individual) individuals[j], village.getVillagers());
                    newPop.add(children[0]);
                    newPop.add(children[1]);
                }
                if (j < individuals.length / 5) {
                    children = this.cross((Individual) individuals[j], village.getVillagers());
                    newPop.add(children[0]);
                    newPop.add(children[1]);
                }
                if (j < individuals.length / 10) {
                    children = this.cross((Individual) individuals[j], village.getVillagers());
                    newPop.add(children[0]);
                    newPop.add(children[1]);
                }
            }

            if (newPop.size() <= village.getSize()) {
                int val = newPop.size();
                for (int i = 0; i < village.getSize() - val; i++) {
                    newPop.add(village.getVillagers().get(rand.nextInt(village.getSize())));
                }
            } else {
                individuals = newPop.toArray();
                Sort.QuickSort(individuals);
                newPop = new ArrayList<Individual>();
                for (int i = 0; i < village.getSize(); i++) {
                    newPop.add((Individual) individuals[i]);
                }
            }
            village.setVillages(newPop);
        }

        /**
         * Elimin weakest.
         *
         * @return the array list
         */
        public ArrayList<Individual> eliminWeakest() {
            ArrayList<Individual> newPop = new ArrayList<Individual>();
            double min_score = 0.5 * village.getAverageScore();
            Object[] individuals = village.getVillagers().toArray();
            Sort.QuickSort(individuals);
            newPop.add(((Individual) individuals[0]));
            for (int j = 1; j < individuals.length / 4; j++) {
                double fitnessScore = ((Individual) individuals[j]).getFitnessScore();
                if (fitnessScore > min_score) {
                    newPop.add(((Individual) individuals[j]));
                } else {
                    break;
                }
            }
            return newPop;
        }

        /**
         * Cross individual [ ].
         *
         * @param father the father
         * @param pop    the pop
         * @return the individual [ ]
         */
        public Individual[] cross(Individual father, ArrayList<Individual> pop) {
            double diff;
            Individual mother = null;
            int count = 0;
            do {
                mother = pop.get(rand.nextInt(pop.size()));
                diff = father.getDiversity(mother);
                count++;
            } while (diff < 0.2 && count < 100);
            Individual[] children = father.cross(mother);
            try {
                children[0].mutate();
                children[1].mutate();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                children[0].improve();
                children[1].improve();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return children;
        }
    }
}
