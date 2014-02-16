package lpostula.pacman.board;

import java.util.List;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Board
 */
public abstract class Board {
    protected int width;
    protected int height;
    protected double cellSize;

    public Board(int nX, int nY, double cellWidth) {
        width = nX;
        height = nY;
        cellSize = cellWidth;
    }

    public abstract int[][] getBoard();

    public abstract Point getStartPoint();

    public abstract Point getEndPoint();

    public abstract List<Integer> getSolution();

    public double getStepSize() {
        return cellSize;
    }

}
