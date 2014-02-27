package lpostula.pacman;

import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lpostula.gameengine.GameWorld;
import lpostula.gameengine.Sprite;
import lpostula.pacman.board.Board;
import lpostula.pacman.board.PacManBoard;
import lpostula.pacman.mobs.*;
import lpostula.pacman.wall.Wall;
import lpostula.pacman.wall.WallFactory;
import lpostula.pacman.wall.WallPosition;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe PacManWorld
 */
public class PacManWorld extends GameWorld {

    private PacMan pacman;
    private Red redMob;
    private Blue blueMob;
    private Path blueMobPath;
    private Path redMobPath;
    private Path pacmanPath;
    private boolean auto = true;
    private long timeLoop = 0;
    private Board board;
    private int column;
    private int row;
    private final double cellWidth = 20;

    /**
     * Instantiates a new Pac man world.
     *
     * @param fps   the fps
     * @param title the title
     * @param auto  the auto
     * @param col   the col
     * @param row   the row
     */
    public PacManWorld(int fps, String title, boolean auto, int col, int row) {
        super(fps, title);
        this.auto = auto;
        this.column = col;
        this.row = row;
    }

    @Override
    public void initialize(Stage primaryStage) {
        // Sets the window title

        // Create the scene
        setSceneNodes(new Group());
        setGameSurface(new Scene(getSceneNodes(), (column + 3) * cellWidth, (row + 3) * cellWidth));
        primaryStage.setScene(getGameSurface());

        //adding the pacman


        //board = new PrimsBoard(column, row, cellWidth, 1, 1);
        //board = new CyclicBoard(column, row, cellWidth, 1, 1);//todo
        //board = new AldousBorder(column, row, cellWidth, 1, 1);//todo link with optionchooser, so factory for board
        board = new PacManBoard(column, row, cellWidth, 1, 1);
        createWall(board, column, row, cellWidth);

        pacman = new PacMan(board, true);
        getSpriteManager().addSprites(pacman);
        getSceneNodes().getChildren().add(pacman.node);
        pacman.node.setTranslateY(2 * cellWidth - cellWidth / 2.0);
        pacman.node.setTranslateX(1 * cellWidth + (cellWidth / 2));
        //pacmanPath = new Path(column, row, cellWidth, pacman);
        //getSceneNodes().getChildren().add(0, pacmanPath.node);

        buildMobs();
        pacman.setRed(redMob);

        if (auto) {
            setInput(primaryStage);
        }

        final Timeline gameLoop = getGameLoop();
    }

    /**
     * Build mobs.
     */
    public void buildMobs() {
        redMob = new Red(board, pacman);
        getSpriteManager().addSprites(redMob);
        redMob.node.setTranslateX(9 * cellWidth + (cellWidth / 2));
        redMob.node.setTranslateY((row / 2) * cellWidth - cellWidth / 2.0);
        //redMobPath = new Path(column, row, cellWidth, redMob);

        /*blueMob = new Blue(board, pacman);
        getSpriteManager().addSprites(blueMob);
        blueMob.node.setTranslateX(1 * board.getStepSize() + (cellWidth / 2));
        blueMob.node.setTranslateY((row - 2) * board.getStepSize() + (cellWidth / 2));
        blueMobPath = new Path(column, row, cellWidth, blueMob);*/

        getSceneNodes().getChildren().add(redMob.node);
        //getSceneNodes().getChildren().add(blueMob.node);
//        getSceneNodes().getChildren().add(0, redMobPath.node);
        //getSceneNodes().getChildren().add(0, blueMobPath.node);
    }

    @Override
    public void updatePath() {
        int skip = 0;
        if (timeLoop % 10 == 0) {
            //pacmanPath.update(skip);
            //redMobPath.update(skip);
            //blueMobPath.update(skip);
            ++skip;
        }
        ++timeLoop;
    }

    private int numberOfNeighboor(int[][] maze, int width, int height, int x, int y) {
        int number = 0;
        if (x > 0 && maze[x - 1][y] == 1) ++number;
        if (x < width && maze[x + 1][y] == 1) ++number;
        if (y > 0 && maze[x][y - 1] == 1) ++number;
        if (y < height && maze[x][y + 1] == 1) ++number;
        return number;
    }

    /**
     * Create wall.
     *
     * @param board the board
     * @param width the width
     * @param height the height
     * @param size the size
     */
    public void createWall(Board board, int width, int height, double size) {
        int[][] maze = board.getBoard();
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (maze[i][j] == 1) {
                    WallPosition pos = null;
                    int numNeighboor = numberOfNeighboor(maze, width - 1, height - 1, i, j);
                    switch (numNeighboor) {
                        case 1:
                            //we need to find wich one
                            if (i > 0 && maze[i - 1][j] == 1) pos = WallPosition.LEFT;
                            else if (i < width && maze[i + 1][j] == 1) pos = WallPosition.RIGHT;
                            else if (j > 0 && maze[i][j - 1] == 1) pos = WallPosition.UP;
                            else if (j < height && maze[i][j + 1] == 1) pos = WallPosition.DOWN;
                            break;
                        case 2:
                            if (i > 0 && maze[i - 1][j] == 1) {
                                if (j > 0 && maze[i][j - 1] == 1) pos = WallPosition.CORNERUPLEFT;
                                else if (j < height - 1 && maze[i][j + 1] == 1) pos = WallPosition.CORNERDOWNLEFT;
                                else pos = WallPosition.HORIZONTAL;
                            } else if (i < width - 1 && maze[i + 1][j] == 1) {
                                if (j > 0 && maze[i][j - 1] == 1) pos = WallPosition.CORNERUPRIGHT;
                                else if (j < height - 1 && maze[i][j + 1] == 1) pos = WallPosition.CORNERDOWNRIGHT;
                                else pos = WallPosition.HORIZONTAL;
                            } else pos = WallPosition.VERTICAL;
                            break;
                        case 3:
                            if (i <= 0 || maze[i - 1][j] == 0) pos = WallPosition.TRIGHT;
                            else if (i >= width - 1 || maze[i + 1][j] == 0) pos = WallPosition.TLEFT;
                            else if (j <= 0 || maze[i][j - 1] == 0) pos = WallPosition.TDOWN;
                            else if (j >= height - 1 || maze[i][j + 1] == 0) pos = WallPosition.TUP;
                            break;
                        case 4:
                            pos = WallPosition.CROSS;

                    }
                    addWall(pos, size, i * size + 1, j * size + 1);
                } else if (maze[i][j] == 2) {
                    //addCanva(Color.BLUE, size, i * size + 1, j * size + 1);
                } else if (maze[i][j] == 3) {
                    //addCanva(Color.RED, size, i * size + 1, j * size + 1);
                } else if (maze[i][j] == 0) {
                    addPowerBall(size, i * size + 1, j * size + 1);
                }
            }
        }
    }

    private void addCanva(Color color, double width, double posX, double posY) {
        Canvas spot = new Canvas(width, width);
        spot.getGraphicsContext2D().setFill(color);
        spot.getGraphicsContext2D().fillRect(0, 0, width, width);
        getSceneNodes().getChildren().add(spot);
        spot.setTranslateX(posX);
        spot.setTranslateY(posY);
    }

    private void addPowerBall(double width, double posX, double posY) {
        PowerBall pB = new PowerBall(width);
        getSceneNodes().getChildren().add(pB.node);
        getSpriteManager().addSprites(pB);
        pB.node.setTranslateX(posX);
        pB.node.setTranslateY(posY);
    }

    private void addWall(WallPosition position, double width, double posX, double posY) {
        Wall wall = WallFactory.buildWall(position, width, posX, posY);
        if (wall != null) {
            getSpriteManager().addSprites(wall);
            getSceneNodes().getChildren().add(0, wall.node);
            wall.node.setTranslateX(posX);
            wall.node.setTranslateY(posY);
        }
    }

    @Override
    protected void handleUpdate(Sprite sprite) {

        /*if (sprite instanceof PacMan) {
            PacMan pac = (PacMan) sprite;
            double x = pac.node.getTranslateX() / cellWidth;
            double y = pac.node.getTranslateY() / cellWidth;
            int wallType = board.getBoard()[((int) Math.floor(x))][((int) Math.floor(y))];
            if (wallType == 3) {
                getGameLoop().stop();
                if (pac.getDirection() == 2) {
                    pacman.node.setTranslateY((row / 2) * cellWidth - cellWidth / 2.0);
                    pacman.node.setTranslateX(cellWidth / 2.0);
                }
            } else if (wallType == 2) {
                if (pac.getDirection() == 1) {
                    pacman.node.setTranslateY((row / 2) * cellWidth - cellWidth / 2.0);
                    pacman.node.setTranslateX((column * cellWidth) - (cellWidth / 2.0));
                }
            }
        }*/
        sprite.update();
    }

    @Override
    protected boolean handleCollision(Sprite spriteA, Sprite spriteB) {
        if (spriteA != spriteB) {
            if (spriteA.collide(spriteB)) {
                if (spriteB == pacman) {
                    if (spriteA instanceof Hunter) {
                        pacman.handleDeath();
                        getGameLoop().pause();
                    } else if (spriteA instanceof Wall) {
                        //pacman.stop();
                    }
                }
                if (spriteA == pacman && spriteB instanceof PowerBall) {
                    ((PowerBall) spriteB).handleDeath();
                    board.setEaten(pacman.getPos());
                }
            }
        }
        return false;
    }

    final private void setInput(Stage primaryStage) {
        EventHandler movePacMan = new EventHandler() {
            @Override
            public void handle(Event event) {
                if (event instanceof KeyEvent) {
                    pacman.move(((KeyEvent) event).getCode());
                }
            }
        };
        primaryStage.getScene().setOnKeyPressed(movePacMan);
    }
}
