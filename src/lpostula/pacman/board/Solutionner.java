package lpostula.pacman.board;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Solutionner
 */
public abstract class Solutionner {
    protected Board board;

    public List<Integer> getPath() {
        return path;
    }

    protected LinkedList<Integer> path;

    public Solutionner(Board board) {
        this.board = board;
    }

    public abstract void run();
}
