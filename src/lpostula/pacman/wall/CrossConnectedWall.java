package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe CrossConnectedWall
 */
public class CrossConnectedWall extends Wall {

    public CrossConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);
        double wallWidth = wallDimension / 2.0;
        double wallIncrement = wallWidth / 2.0;
        double[] pointsX = {
                0.0,
                wallDimension,
                wallDimension,
                0.0
        };
        double[] pointsY = {
                wallIncrement,
                wallIncrement,
                wallIncrement + wallWidth,
                wallIncrement + wallWidth};
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().fillPolygon(pointsX, pointsY, 4);
        canva.getGraphicsContext2D().fillPolygon(pointsY, pointsX, 4);
        node = canva;
    }
}
