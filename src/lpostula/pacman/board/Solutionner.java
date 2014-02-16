package lpostula.pacman.board;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Solutionner
 */
public abstract class Solutionner {
    protected Board board;

    public Solutionner(Board board) {
        this.board = board;
    }

    public abstract void run();
}
