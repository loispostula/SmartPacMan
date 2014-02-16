package lpostula.pacman.board;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe PrimsBoard
 */
public class PrimsBoard extends Board {
    private static final int IN = 0;
    private static final int FRONTIER = 1;
    private static final int OUT = 2;
    private Random rand = new Random();
    private int startX;
    private int startY;
    private int[][] maze;

    public PrimsBoard(int nX, int nY, double cellWidth, int sX, int sY) {
        super(nX, nY, cellWidth);
        startX = sX;
        startY = sY;
        maze = new int[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                maze[i][j] = 1;
            }
        }

        // select random point and open as start node
        Point st = new Point(startX, startY, null);
        maze[st.x][st.y] = 2;

        // iterate through direct neighbors of node
        ArrayList<Point> frontier = new ArrayList<Point>();
        for (int i = -1; i <= 1; ++i)
            for (int j = -1; j <= 1; ++j) {
                if (i == 0 && j == 0 || i != 0 && j != 0)
                    continue;
                try {
                    if (maze[st.x + i][st.y + j] == 0) continue;
                } catch (Exception e) { // ignore ArrayIndexOutOfBounds
                    continue;
                }
                // add eligible points to frontier
                frontier.add(new Point(st.x + i, st.y + j, st));
            }

        Point last = null;
        while (!frontier.isEmpty()) {

            // pick current node at random
            Point cu = frontier.remove((int) (Math.random() * frontier.size()));
            Point op = cu.opposite();
            try {
                // if both node and its opposite are walls
                if (maze[cu.x][cu.y] == 1) {
                    if (maze[op.x][op.y] == 1) {

                        // open path between the nodes
                        maze[cu.x][cu.y] = 0;
                        maze[op.x][op.y] = 0;

                        // store last node in order to mark it later
                        last = op;

                        // iterate through direct neighbors of node, same as earlier
                        for (int i = -1; i <= 1; ++i)
                            for (int j = -1; j <= 1; ++j) {
                                if (i == 0 && j == 0 || i != 0 && j != 0)
                                    continue;
                                try {
                                    if (maze[op.x + i][op.y + j] == 0) continue;
                                } catch (Exception e) {
                                    continue;
                                }
                                frontier.add(new Point(op.x + i, op.y + j, op));
                            }
                    }
                }
            } catch (Exception e) { // ignore NullPointer and ArrayIndexOutOfBounds
            }

            // if algorithm has resolved, mark end node
            if (frontier.isEmpty())
                maze[last.x][last.y] = 3;
        }
    }

    static class Point {
        Integer x;
        Integer y;
        Point parent;

        public Point(int x, int y, Point p) {
            this.x = x;
            this.y = y;
            parent = p;
        }

        // compute opposite node given that it is in the other direction from the parent
        public Point opposite() {
            if (this.x.compareTo(parent.x) != 0)
                return new Point(this.x + this.x.compareTo(parent.x), this.y, this);
            if (this.y.compareTo(parent.y) != 0)
                return new Point(this.x, this.y + this.y.compareTo(parent.y), this);
            return null;
        }
    }

    public int[][] getMaze() {
        return maze;
    }
}