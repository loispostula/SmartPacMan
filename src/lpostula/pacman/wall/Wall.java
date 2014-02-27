/*
 * This file is part of SmartPacMan.
 *
 *     SmartPacMan is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     SmartPacMan is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with SmartPacMan.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of SmartPacMan.
 *
 *     SmartPacMan is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     SmartPacMan is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with SmartPacMan.  If not, see <http://www.gnu.org/licenses/>.
 */

package lpostula.pacman.wall;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import lpostula.gameengine.Sprite;
import lpostula.pacman.mobs.Hunter;
import lpostula.pacman.mobs.PacMan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe Wall
 */
public abstract class Wall extends Sprite {
    /**
     * The Wall dimension.
     */
    protected double wallDimension;
    /**
     * The Canva.
     */
    protected Canvas canva;
    /**
     * The Wall width.
     */
    protected double wallWidth;
    /**
     * The Pos x.
     */
    protected double posX;
    /**
     * The Pos y.
     */
    protected double posY;
    /**
     * The Wall increment.
     */
    protected double wallIncrement;
    /**
     * The Wall constructed.
     */
    protected boolean wallConstructed;
    /**
     * The Line left.
     */
    protected List<Line> lineLeft = new ArrayList<Line>();
    /**
     * The Line right.
     */
    protected List<Line> lineRight = new ArrayList<Line>();
    /**
     * The Line up.
     */
    protected List<Line> lineUp = new ArrayList<Line>();
    /**
     * The Line down.
     */
    protected List<Line> lineDown = new ArrayList<Line>();
    /**
     * The constant COLOR.
     */
    protected static final Color COLOR = Color.DIMGREY;

    /**
     * Instantiates a new Wall.
     *
     * @param dimension the dimension
     * @param x         the x
     * @param y         the y
     */
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

    /**
     * Construct line.
     */
    public void constructLine() {
    }

    ;

    @Override
    public boolean collide(Sprite other) {
        boolean collide = false;
        if (other instanceof PacMan || other instanceof Hunter) {
            Circle circle = (Circle) other.node;
            Point2D center = other.node.localToParent(circle.getCenterX(), circle.getCenterY());
            List<Line> toCheck = new ArrayList<Line>();
            switch (other.getDirection()) {
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

    @Override
    public int getDirection() {
        return 0;
    }
}
