package lpostula.pacman.board;

/**
 * Created by lpostula on 24/02/14.
 * Documentation de la classe CyclicBoard
 */
public class CyclicBoard extends Board {
    /**
     * Instantiates a new Board.
     *
     * @param nX        the n x
     * @param nY        the n y
     * @param cellWidth the cell width
     * @param sX
     * @param sY
     */
    public CyclicBoard(int nX, int nY, double cellWidth, int sX, int sY) {
        super(nX, nY, cellWidth, sX, sY);
    }
}
