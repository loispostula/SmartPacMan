package lpostula.pacman.board;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Point
 */
public class Point {
    public Integer x;
    public Integer y;
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

    public boolean equals(Point obj) {
        return x == obj.x && y == obj.y;
    }

    @Override
    public String toString() {
        return ('(' + Integer.toString(x) + ',' + Integer.toString(y) + ')');
    }
}
