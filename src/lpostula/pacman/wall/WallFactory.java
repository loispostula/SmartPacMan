package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe WallFactory
 */
public class WallFactory {
    public static Wall buildWall(WallPosition position, double dimension, double posX, double posY) {
        Wall wall = null;
        switch (position) {
            case LEFT:
                wall = new LeftConnectedWall(dimension, posX, posY);
                break;
            case RIGHT:
                wall = new RightConnectedWall(dimension, posX, posY);
                break;
            case UP:
                wall = new UpConnectedWall(dimension, posX, posY);
                break;
            case DOWN:
                wall = new DownConnectedWall(dimension, posX, posY);
                break;
            case HORIZONTAL:
                wall = new HorizontalConnectedWall(dimension, posX, posY);
                break;
            case VERTICAL:
                wall = new VerticalConnectedWall(dimension, posX, posY);
                break;
            case CROSS:
                wall = new CrossConnectedWall(dimension, posX, posY);
                break;
            case CORNERUPLEFT:
                wall = new UpLeftConnectedWall(dimension, posX, posY);
                break;
            case CORNERUPRIGHT:
                wall = new UpRightConnectedWall(dimension, posX, posY);
                break;
            case CORNERDOWNLEFT:
                wall = new DownLeftConnectedWall(dimension, posX, posY);
                break;
            case CORNERDOWNRIGHT:
                wall = new DownRightConnectedWall(dimension, posX, posY);
                break;
            case TLEFT:
                wall = new TLeftConnectedWall(dimension, posX, posY);
                break;
            case TUP:
                wall = new TupConnectedWall(dimension, posX, posY);
                break;
            case TRIGHT:
                wall = new TRightConnectedWall(dimension, posX, posY);
                break;
            case TDOWN:
                wall = new TDownConnectedWall(dimension, posX, posY);
        }
        return wall;
    }
}
