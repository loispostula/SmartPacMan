package lpostula.pacman.wall;

import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe UpLeftConnectedWall
 */
public class DownLeftConnectedWall extends CornerWall {
    public DownLeftConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);

        xBoundMinMain = 0.0;
        xBoundMaxMain = wallIncrement + wallWidth;

        xBoundMinSmall = wallIncrement;
        xBoundMaxSmall = wallIncrement + wallWidth;

        yBoundMinMain = wallIncrement;
        yBoundMaxMain = wallWidth + wallIncrement;

        yBoundMinSmall = wallWidth + wallIncrement;
        yBoundMaxSmall = wallDimension;

        constructCanva();
    }

    @Override
    public void constructLine() {
        double mainMinX = xBoundMinMain + posX;
        double mainMinY = yBoundMinMain + posY;
        double mainMaxX = mainMinX + widthMain;
        double mainMaxY = mainMinY + heightMain;
        double smallMinX = xBoundMinSmall + posX;
        double smallMinY = yBoundMinSmall + posY;
        double smallMaxX = xBoundMaxSmall + posX;
        double smallMaxY = yBoundMaxSmall + posY;
        lineUp.add(new Line(mainMinX, mainMinY, mainMaxX, mainMinY));
        lineRight.add(new Line(mainMaxX, mainMinY, mainMaxX, mainMaxY));
        lineLeft.add(new Line(smallMinX, smallMinY, smallMinX, smallMaxY));
        lineDown.add(new Line(mainMinX, mainMaxY, smallMinX, mainMaxY));
    }
}
