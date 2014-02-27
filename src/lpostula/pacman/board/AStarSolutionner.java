package lpostula.pacman.board;

import java.util.*;

/**
 * Created by lpostula on 24/02/14.
 * Documentation de la classe AStarSolutionner
 */
public class AStarSolutionner extends Solutionner {
    /**
     * The Start.
     */
    protected Node start;
    /**
     * The End.
     */
    protected Node end;

    /**
     * Instantiates a new A star solutionner.
     *
     * @param board the board
     */
    public AStarSolutionner(Board board) {
        super(board);
        board.calcSuccessorList();
    }


    /**
     * Set start.
     *
     * @param x the x
     * @param y the y
     */
    public void setStart(int x, int y) {
        start = new Node(x, y);
    }

    /**
     * Set end.
     *
     * @param x the x
     * @param y the y
     */
    public void setEnd(int x, int y) {
        end = new Node(x, y);
    }

    private int computeDir(Node orig, Node target) {
        if (target.x == orig.x - 1) return Direction.LEFT.ordinal();
        if (target.y == orig.y - 1) return Direction.UP.ordinal();
        if (target.y == orig.y + 1) return Direction.DOWN.ordinal();
        if (target.x == orig.x + 1) return Direction.RIGHT.ordinal();
        return 4;
    }

    @Override
    public void run() {
        path = new LinkedList<>();
        LinkedList<Node> directions = new LinkedList<>();
        Queue<Node> q = new LinkedList<Node>();
        Set<Node> vis = new HashSet<Node>();
        Map<Node, Node> prev = new HashMap<Node, Node>();
        Node current = start;
        q.add(current);
        vis.add(current);
        while (!q.isEmpty()) {
            current = q.remove();
            if (current.equals(end)) {
                break;
            } else {
                for (Node node : current.getOutNodes()) {
                    if (!vis.contains(node)) {
                        q.add(node);
                        vis.add(node);
                        prev.put(node, current);
                    }
                }
            }
        }
        if (!current.equals(end)) {
            System.out.println("nope");
        }
        for (Node node = end; node != null; node = prev.get(node)) {
            directions.add(node);
        }
        Collections.reverse(directions);
        for (int i = 0; i < directions.size() - 1; ++i) {
            path.add(computeDir(directions.get(i), directions.get(i + 1)));
        }
    }

    private class Node {
        /**
         * The X.
         */
        public int x;
        /**
         * The Y.
         */
        public int y;

        /**
         * Instantiates a new Node.
         *
         * @param x the x
         * @param y the y
         */
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node) {
                return (x == ((Node) obj).x && y == ((Node) obj).y);
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hashCode = 23;
            hashCode *= 37;
            hashCode += x;
            hashCode *= 37;
            hashCode += y;
            return hashCode;
        }

        /**
         * Get out nodes.
         *
         * @return the list
         */
        public List<Node> getOutNodes() {
            List<Node> nodes = new ArrayList<>();
            boolean[] succ = board.getSuccList()[x * board.height + y];
            if (succ[Direction.UP.ordinal()]) nodes.add(new Node(x - 1, y));
            if (succ[Direction.LEFT.ordinal()]) nodes.add(new Node(x, y - 1));
            if (succ[Direction.RIGHT.ordinal()]) nodes.add(new Node(x, y + 1));
            if (succ[Direction.DOWN.ordinal()]) nodes.add(new Node(x + 1, y));
            return nodes;
        }

        @Override
        public String toString() {
            return Integer.toString(x) + " - " + Integer.toString(y);
        }
    }
}
