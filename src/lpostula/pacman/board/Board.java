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


    /**
     * The Start x.
     */
    protected int startX;
    /**
     * The Start y.
     */
    protected int startY;
    /**
     * The Maze.
     */
    protected int[][] maze;
    /**
     * The Succ list.
     */
    protected boolean[][] succList;
    /**
     * The End point.
     */
    protected Point endPoint;

    /**
     * Instantiates a new Board.
     *
     * @param nX        the n x
     * @param nY        the n y
     * @param cellWidth the cell width
     * @param sX        the s x
     * @param sY        the s y
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


    /**
     * Get board.
     *
     * @return the int [ ] [ ]
     */
    public int[][] getBoard() {
        return maze;
    }


    /**
     * Gets start point.
     *
     * @return the start point
     */
    public Point getStartPoint() {
        return new Point(startX, startY, null);
    }

    /**
     * Gets end point.
     *
     * @return the end point
     */
    public Point getEndPoint() {
        return endPoint;
    }

    /**
     * Calc successor list.
     */
    public void calcSuccessorList() {
        boolean[][] successList = new boolean[width * height][4];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (maze[i][j] == 0 || maze[i][j] == 2 || maze[i][j] == 3 || maze[i][j] == -1) {
                    try {
                        if (maze[i - 1][j] != 1) {
                            successList[i * height + j][Direction.UP.ordinal()] = true;
                        } else {
                            successList[i * height + j][Direction.UP.ordinal()] = false;
                        }
                    } catch (Exception e) {
                        successList[i * height + j][Direction.UP.ordinal()] = false;
                    }
                    try {
                        if (maze[i][j - 1] != 1) {
                            successList[i * height + j][Direction.LEFT.ordinal()] = true;
                        } else {
                            successList[i * height + j][Direction.LEFT.ordinal()] = false;
                        }
                    } catch (Exception e) {
                        successList[i * height + j][Direction.LEFT.ordinal()] = false;
                    }
                    try {
                        if (maze[i][j + 1] != 1) {
                            successList[i * height + j][Direction.RIGHT.ordinal()] = true;
                        } else {
                            successList[i * height + j][Direction.RIGHT.ordinal()] = false;
                        }
                    } catch (Exception e) {
                        successList[i * height + j][Direction.RIGHT.ordinal()] = false;
                    }
                    try {
                        if (maze[i + 1][j] != 1) {
                            successList[i * height + j][Direction.DOWN.ordinal()] = true;
                        } else {
                            successList[i * height + j][Direction.DOWN.ordinal()] = false;
                        }
                    } catch (Exception e) {
                        successList[i * height + j][Direction.DOWN.ordinal()] = false;
                    }
                }
            }
        }
        this.succList = successList;
    }

    /**
     * Get succ list.
     *
     * @return the boolean [ ] [ ]
     */
    public boolean[][] getSuccList() {
        return succList;
    }

    /**
     * Sets eaten.
     *
     * @param pos the pos
     */
    public void setEaten(Point pos) {
        maze[pos.x][pos.y] = 5;
    }
}
