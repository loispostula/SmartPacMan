package lpostula.pacman.mobs;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import lpostula.gameengine.Sprite;
import lpostula.pacman.board.Board;
import lpostula.pacman.board.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Hunter
 */
public abstract class Hunter extends Sprite {
    public static final int DIMENSION = 7;
    public double SPEED_FACTOR = 10;
    protected Color MOB_COLOR = Color.RED;
    private int direction = 4;
    protected Board board;
    private int step = 0;
    protected List<Integer> path = new ArrayList<>();
    protected Point position = new Point(-1, -1, null);
    protected Point initPosForPath = new Point(-1, -1, null);
    protected PacMan target;

    public Hunter(Board board, PacMan target) {
        this.board = board;
        this.vX = this.vY = board.getStepSize() / SPEED_FACTOR;
        this.target = target;

    }

    protected void constructNode() {
        Circle sphere = new Circle(DIMENSION);
        sphere.setFill(MOB_COLOR);
        sphere.setVisible(true);
        node = sphere;

    }

    @Override
    public void update() {
        position.x = (int) Math.floor(node.getTranslateX() / board.getStepSize());
        position.y = (int) Math.floor(node.getTranslateY() / board.getStepSize());
        if (step % SPEED_FACTOR == 0) {
            computePath();
            initPosForPath.x = position.x;
            initPosForPath.y = position.y;
            if (!path.isEmpty()) {
                direction = path.get(0);
                if (direction == -1) {
                }
            }
        }
        ++step;
        int modX = 0;
        int modY = 0;
        switch (direction) {
            case 0:
                modX = 0;
                modY = -1;
                break;
            case 1:
                modX = -1;
                modY = 0;
                break;
            case 2:
                modX = 1;
                modY = 0;
                break;
            case 3:
                modX = 0;
                modY = 1;
                break;
            case 4:
                modX = 0;
                modY = 0;
                break;
        }
        node.setTranslateX(node.getTranslateX() + (modX * vX));
        node.setTranslateY(node.getTranslateY() + (modY * vY));
    }

    protected abstract void computePath();

    @Override
    public int getDirection() {
        return direction;
    }

    @Override
    public boolean collide(Sprite other) {
        if (other instanceof PacMan) {
            Circle otherSphere = (Circle) other.node;
            Circle thisSphere = (Circle) node;
            Point2D otherCenter = otherSphere.localToScene(otherSphere.getCenterX(), otherSphere.getCenterY());
            Point2D thisCenter = thisSphere.localToScene(thisSphere.getCenterX(), thisSphere.getCenterY());
            double dx = otherCenter.getX() - thisCenter.getX();
            double dy = otherCenter.getY() - thisCenter.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
            double minDist = otherSphere.getRadius() + thisSphere.getRadius();
            return (distance < minDist);
        } else if (other instanceof Hunter) {
            return false;
        } else return other.collide(this);
    }

    public List<Integer> getPath() {
        return path;
    }

    public Point getPosition() {
        return position;
    }

    public Point getInitPosForPath() {
        return initPosForPath;
    }

    public Color getColor() {
        return MOB_COLOR;
    }

}
