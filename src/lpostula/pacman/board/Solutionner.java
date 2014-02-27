package lpostula.pacman.board;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Solutionner
 */
public abstract class Solutionner {
    /**
     * The Board.
     */
    protected Board board;

    /**
     * Gets path.
     *
     * @return the path
     */
    public List<Integer> getPath() {
        return path;
    }

    /**
     * The Path.
     */
    protected LinkedList<Integer> path = new LinkedList<>();

    /**
     * Instantiates a new Solutionner.
     *
     * @param board the board
     */
    public Solutionner(Board board) {
        this.board = board;
    }

    /**
     * Run void.
     */
    public abstract void run();
}
