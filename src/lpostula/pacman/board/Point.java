package lpostula.pacman.board;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Point
 */
public class Point {
    /**
     * The X.
     */
    public Integer x;
    /**
     * The Y.
     */
    public Integer y;
    Point parent;

    /**
     * Instantiates a new Point.
     *
     * @param x the x
     * @param y the y
     * @param p the p
     */
    public Point(int x, int y, Point p) {
        this.x = x;
        this.y = y;
        parent = p;
    }

    /**
     * Opposite point.
     *
     * @return the point
     */// compute opposite node given that it is in the other direction from the parent
    public Point opposite() {
        if (this.x.compareTo(parent.x) != 0)
            return new Point(this.x + this.x.compareTo(parent.x), this.y, this);
        if (this.y.compareTo(parent.y) != 0)
            return new Point(this.x, this.y + this.y.compareTo(parent.y), this);
        return null;
    }

    /**
     * Equals boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public boolean equals(Point obj) {
        return x == obj.x && y == obj.y;
    }

    @Override
    public String toString() {
        return ('(' + Integer.toString(x) + ',' + Integer.toString(y) + ')');
    }

    /**
     * Gets distance.
     *
     * @param other the other
     * @return the distance
     */
    public double getDistance(Point other) {
        double distance_x = other.x - x;
        double distance_y = other.y - y;
        return Math.sqrt(distance_x * distance_x + distance_y * distance_y);

    }
}
