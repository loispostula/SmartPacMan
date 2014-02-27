package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe TConnectedWall
 */
public class TConnectedWall extends Wall {
    /**
     * The X bound big.
     */
    protected double xBoundBig;
    /**
     * The Y bound big.
     */
    protected double yBoundBig;
    /**
     * The X bound small.
     */
    protected double xBoundSmall;
    /**
     * The Y bound small.
     */
    protected double yBoundSmall;
    /**
     * The Width big.
     */
    protected double widthBig;
    /**
     * The Height big.
     */
    protected double heightBig;
    /**
     * The Width small.
     */
    protected double widthSmall;
    /**
     * The Height small.
     */
    protected double heightSmall;

    /**
     * Instantiates a new T connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public TConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
    }

    /**
     * Construct canva.
     */
    public void constructCanva() {
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().setFill(COLOR);
        canva.getGraphicsContext2D().fillRect(xBoundBig, yBoundBig, widthBig, heightBig);
        canva.getGraphicsContext2D().fillRect(xBoundSmall, yBoundSmall, widthSmall, heightSmall);
        node = canva;
        node.setVisible(true);
        constructLine();
    }
}
