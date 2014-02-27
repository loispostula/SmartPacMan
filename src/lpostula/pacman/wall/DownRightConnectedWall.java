package lpostula.pacman.wall;

import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe UpLeftConnectedWall
 */
public class DownRightConnectedWall extends CornerWall {
    /**
     * Instantiates a new Down right connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public DownRightConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);

        xBoundMinMain = wallIncrement;
        xBoundMaxMain = wallDimension;

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
        lineRight.add(new Line(smallMaxX, mainMaxY, smallMaxX, smallMaxY));
        lineLeft.add(new Line(mainMinX, mainMinY, mainMinX, smallMaxY));
        lineDown.add(new Line(smallMaxX, mainMaxY, mainMaxX, mainMaxY));
    }
}
