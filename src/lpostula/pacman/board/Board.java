package lpostula.pacman.board;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Board
 */
public abstract class Board {
    /**
     * The Width.
     */
    protected int width;
    /**
     * The Height.
     */
    protected int height;
    /**
     * The Cell size.
     */
    protected double cellSize;


    protected int startX;
    protected int startY;
    protected int[][] maze;
    protected Point endPoint;

    /**
     * Instantiates a new Board.
     *
     * @param nX        the n x
     * @param nY        the n y
     * @param cellWidth the cell width
     */
    public Board(int nX, int nY, double cellWidth, int sX, int sY) {
        width = nX;
        height = nY;
        startX = sX;
        startY = sY;
        cellSize = cellWidth;
        maze = new int[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                maze[i][j] = 1;
            }
        }
    }

    /**
     * Gets step size.
     *
     * @return the step size
     */
    public double getStepSize() {
        return cellSize;
    }


    public int[][] getBoard() {
        return maze;
    }


    public Point getStartPoint() {
        return new Point(startX, startY, null);
    }

    public Point getEndPoint() {
        return endPoint;
    }

}
