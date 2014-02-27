package lpostula.pacman.wall;

import javafx.scene.shape.Line;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe UpRightConnectedWall
 */
public class UpRightConnectedWall extends CornerWall {
    /**
     * Instantiates a new Up right connected wall.
     *
     * @param dimension the dimension
     * @param posX      the pos x
     * @param posY      the pos y
     */
    public UpRightConnectedWall(double dimension, double posX, double posY) {
        super(dimension, posX, posY);

        xBoundMinMain = wallIncrement;
        xBoundMaxMain = wallDimension;

        xBoundMinSmall = wallIncrement;
        xBoundMaxSmall = wallIncrement + wallWidth;

        yBoundMinMain = wallIncrement;
        yBoundMaxMain = wallIncrement + wallWidth;

        yBoundMinSmall = 0.0;
        yBoundMaxSmall = wallIncrement;

        constructCanva();
        checkDown = checkRight = false;
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
        lineDown.add(new Line(mainMinX, mainMaxY, mainMaxX, mainMaxY));
        lineLeft.add(new Line(mainMinX, smallMinY, mainMinX, mainMaxY));
        lineRight.add(new Line(smallMaxX, smallMinY, smallMaxX, smallMaxY));
        lineUp.add(new Line(smallMaxX, smallMaxY, mainMaxX, smallMaxY));
    }
}
