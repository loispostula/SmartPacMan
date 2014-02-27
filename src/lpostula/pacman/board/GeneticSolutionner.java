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
        System.out.println(p.getFitest().getPowerballEaten());
    }
}
