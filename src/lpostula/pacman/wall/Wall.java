package lpostula.pacman.wall;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import lpostula.gameengine.Sprite;
import lpostula.pacman.PacMan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe Wall
 */
public abstract class Wall extends Sprite {
    protected double wallDimension;
    protected Canvas canva;
    protected double wallWidth;
    protected double posX;
    protected double posY;
    protected double wallIncrement;
    protected boolean wallConstructed;
    protected List<Line> lineLeft = new ArrayList<Line>();
    protected List<Line> lineRight = new ArrayList<Line>();
    protected List<Line> lineUp = new ArrayList<Line>();
    protected List<Line> lineDown = new ArrayList<Line>();

    public Wall(double dimension, double x, double y) {
        //we will draw the path of every wall
        wallDimension = dimension;
        posX = x;
        posY = y;
        wallWidth = wallDimension / 2.0;
        wallIncrement = wallWidth / 2.0;
    }

    private double dist(Point2D a, Point2D b) {
        return ((a.getX() - b.getX()) * (a.getX() - b.getX())) + ((a.getY() - b.getY()) * (a.getY() - b.getY()));
    }

    private double getDistance(Line segment, Point2D C) {
        Point2D a = new Point2D(segment.getStartX(), segment.getStartY());
        Point2D b = new Point2D(segment.getEndX(), segment.getEndY());
        double pA = C.getX() - a.getX();
        double pB = C.getY() - a.getY();
        double pC = b.getX() - a.getX();
        double pD = b.getY() - a.getY();

        double dot = pA * pC + pB * pD;
        double len_sq = pC * pC + pD * pD;
        double param = dot / len_sq;

        double xx, yy;

        if (param < 0 || ((a.getX() == b.getX()) && (a.getY() == b.getY()))) {
            xx = a.getX();
            yy = a.getY();
        } else if (param > 1) {
            xx = b.getX();
            yy = b.getY();
        } else {
            xx = a.getX() + param * pC;
            yy = a.getY() + param * pD;
        }

        double dx = C.getX() - xx;
        double dy = C.getY() - yy;
        return Math.sqrt(dx * dx + dy * dy);

    }

    public void constructLine() {
    }

    ;

    @Override
    public boolean collide(Sprite other) {
        boolean collide = false;
        if (other instanceof PacMan) {
            PacMan cand = (PacMan) other;
            Circle circle = (Circle) other.node;
            Point2D center = cand.node.localToParent(circle.getCenterX(), circle.getCenterY());
            List<Line> toCheck = new ArrayList<Line>();
            switch (cand.getDirection()) {
                case 0:
                    //left
                    toCheck.addAll(lineRight);
                    break;
                case 1:
                    //right
                    toCheck.addAll(lineLeft);
                    break;
                case 2:
                    //up
                    toCheck.addAll(lineDown);
                    break;
                case 3:
                    //down
                    toCheck.addAll(lineUp);
                    break;
            }
            double distance = 0.0;
            for (Line line : toCheck) {
                distance = getDistance(line, center);
                collide = collide || ((distance) < circle.getRadius());
            }
        }
        return collide;
    }

    @Override
    public void update() {
    }
}
