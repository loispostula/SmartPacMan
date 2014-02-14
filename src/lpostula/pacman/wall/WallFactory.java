package lpostula.pacman.wall;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe WallFactory
 */
public class WallFactory {
    public static Wall buildWall(WallPosition position, double dimension) {
        Wall wall = null;
        switch (position) {
            case LEFT:
                wall = new LeftConnectedWall(dimension);
                break;
            case RIGHT:
                wall = new RightConnectedWall(dimension);
                break;
            case UP:
                wall = new UpConnectedWall(dimension);
                break;
            case DOWN:
                wall = new DownConnectedWall(dimension);
                break;
            case HORIZONTAL:
                wall = new HorizontalConnectedWall(dimension);
                break;
            case VERTICAL:
                wall = new VerticalConnectedWall(dimension);
                break;
            case CROSS:
                wall = new CrossConnectedWall(dimension);
                break;
            case CORNERUPLEFT:
                wall = new UpLeftConnectedWall(dimension);
                break;
            case CORNERUPRIGHT:
                wall = new UpRightConnectedWall(dimension);
                break;
            case CORNERDOWNLEFT:
                wall = new DownLeftConnectedWall(dimension);
                break;
            case CORNERDOWNRIGHT:
                wall = new DownRightConnectedWall(dimension);
                break;
            case TLEFT:
                wall = new TLeftConnectedWall(dimension);
                break;
            case TUP:
                wall = new TupConnectedWall(dimension);
                break;
            case TRIGHT:
                wall = new TRightConnectedWall(dimension);
                break;
            case TDOWN:
                wall = new TDownConnectedWall(dimension);
        }
        return wall;
    }
}
