package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe TDownConnectedWall
 */
public class TDownConnectedWall extends Wall {

    public TDownConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        double wallWidth = wallDimension / 2.0;
        double wallIncrement = wallWidth / 2.0;
        double[] pointsX = {
                wallIncrement,
                wallIncrement,
                0.0,
                0.0,
                wallIncrement,
                wallIncrement,
                wallIncrement + wallWidth,
                wallIncrement + wallWidth
        };
        double[] pointsY = {
                0.0,
                wallIncrement,
                wallIncrement,
                wallIncrement + wallWidth,
                wallIncrement + wallWidth,
                wallDimension,
                wallDimension,
                0.0};
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().fillPolygon(pointsX, pointsY, 8);
        canva.setRotate(270);
        node = canva;
    }
}
