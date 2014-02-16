package lpostula.pacman.board;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe RecursifSolutioner
 */
public class RecursifSolutioner extends Solutionner {
    private int[][] maze;
    private final LinkedList<Integer> path;
    private Point end;
    private Point start;
    private boolean stop = false;

    public RecursifSolutioner(Board board) {
        super(board);
        int[][] tmpMaze = board.getBoard();
        maze = new int[board.width][board.height];
        for (int i = 0; i < board.width; ++i) {
            System.arraycopy(tmpMaze[i], 0, maze[i], 0, board.height);
        }
        end = board.getEndPoint();
        start = board.getStartPoint();
        path = new LinkedList<>();
        run();
    }

    public RecursifSolutioner(Board board, Point start, Point end) {
        super(board);
        int[][] tmpMaze = board.getBoard();
        maze = new int[board.width][board.height];
        for (int i = 0; i < board.width; ++i) {
            System.arraycopy(tmpMaze[i], 0, maze[i], 0, board.height);
        }
        this.end = end;
        this.start = start;
        path = new LinkedList<>();
        run();
    }

    @Override
    public void run() {
        compute(-1, start);
    }

    private Point[] getAdjacentCell(Point current) {
        Point[] adj = new Point[4];
        adj[0] = new Point(current.x, current.y - 1, null);
        adj[1] = new Point(current.x - 1, current.y, null);
        adj[2] = new Point(current.x + 1, current.y, null);
        adj[3] = new Point(current.x, current.y + 1, null);
        return adj;
    }

    private boolean cellFree(Point cand) {
        if (cand.x < 0 || cand.x >= board.width ||
                cand.y < 0 || cand.y >= board.height) {
            return false;
        }
        return (maze[cand.x][cand.y] == 0 || maze[cand.x][cand.y] == 3);

    }

    private void addInMaze(Point cand) {
        maze[cand.x][cand.y] = 4;
    }

    private void removeInMaze(Point cand) {
        maze[cand.x][cand.y] = 0;
    }

    private int invert(int i) {
        switch (i) {
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 0;
        }
        ;
        return -1;
    }

    private boolean compute(int prev, Point current) {
        if (current.equals(end)) {
            return true;
        }

        Point[] adjacentCell = getAdjacentCell(current);
        for (int i = 0; i < 4; ++i) {
            if (i != invert(prev)) {
                Point cand = adjacentCell[i];
                if (cellFree(cand)) {
                    addInMaze(cand);
                    if (compute(i, cand)) {
                        path.add(0, i);
                        return true;
                    }
                    removeInMaze(cand);
                }
            }
        }
        return false;
    }

    private boolean tryDir(int direction, Point current) {
        boolean doable = false;
        switch (direction) {
            case (0):
                //up
                try {
                    doable = maze[current.x][current.y - 1] != 1;
                } catch (Exception e) {
                }
                ;
                break;
            case (1):
                //left
                try {
                    doable = maze[current.x - 1][current.y] != 1;
                } catch (Exception e) {
                }
                ;
                break;
            case (2):
                //right
                try {
                    doable = maze[current.x + 1][current.y] != 1;
                } catch (Exception e) {
                }
                ;
                break;
            case (3):
                //down
                try {
                    doable = maze[current.x][current.y + 1] != 1;
                } catch (Exception e) {
                }
                ;
                break;
        }
        return doable;
    }

    private int computeDirection(Point orig, Point end) {
        int direction = -1;
        if (orig.x == orig.y && orig.x == -1) {
            direction = -1;
        } else if (orig.y == end.y + 1) {
            //up
            direction = 0;
        } else if (orig.x == end.x + 1) {
            //left
            direction = 1;
        } else if (orig.x == end.x - 1) {
            //right
            direction = 2;
        } else direction = 3;//down
        return direction;
    }

    public List<Integer> getPath() {
        return path;
    }
}
