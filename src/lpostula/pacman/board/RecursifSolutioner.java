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
        maze = board.getBoard();
        end = board.getEndPoint();
        start = board.getStartPoint();
        path = new LinkedList<>();
        run();
    }

    @Override
    public void run() {
        compute(new Point(-1, -1, null), start);
    }

    private void compute(Point previous, Point current) {
        int direction = computeDirection(previous, current);
        if (!stop) {
            path.add(new Integer(direction));
        }
        if (stop || current.equals(end)) {

            stop = true;
        } else {
            if (direction != 0 && tryDir(3, current)) {
                //down
                Point next = new Point(current.x, current.y + 1, null);
                compute(current, next);
                if (!stop) path.pollLast();
            }
            if (direction != 1 && tryDir(2, current)) {
                //right
                Point next = new Point(current.x + 1, current.y, null);
                compute(current, next);
                if (!stop) path.pollLast();
            }
            if (direction != 2 && tryDir(1, current)) {
                //left
                Point next = new Point(current.x - 1, current.y, null);
                compute(current, next);
                if (!stop) path.pollLast();
            }
            if (direction != 3 && tryDir(0, current)) {
                //up
                Point next = new Point(current.x, current.y - 1, null);
                compute(current, next);
                if (!stop) path.pollLast();
            }
        }
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
