package lpostula.pacman.wall;

import javafx.scene.canvas.Canvas;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe DownConnectedWall
 */
public class DownConnectedWall extends Wall {

    public DownConnectedWall(double dimension) {
        super(dimension);
        double wallWidth = wallDimension / 2.0;
        double wallIncrement = wallWidth / 2.0;
        double[] pointsX = {
                0.0,
                wallIncrement + wallWidth,
                wallIncrement + wallWidth,
                0.0};
        double[] pointsY = {
                wallIncrement,
                wallIncrement,
                wallIncrement + wallWidth,
                wallIncrement + wallWidth};
        Canvas canva = new Canvas(wallDimension, wallDimension);
        canva.getGraphicsContext2D().fillPolygon(pointsX, pointsY, 4);
        canva.setRotate(270.0);
        node = canva;
    }
}
