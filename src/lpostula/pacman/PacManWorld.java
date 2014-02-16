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
import lpostula.pacman.board.PrimsBoard;
import lpostula.pacman.mobs.PacMan;
import lpostula.pacman.wall.Wall;
import lpostula.pacman.wall.WallFactory;
import lpostula.pacman.wall.WallPosition;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe PacManWorld
 */
public class PacManWorld extends GameWorld {

    private PacMan pacman;
    private boolean auto = true;

    public PacManWorld(int fps, String title, boolean auto) {
        super(fps, title);
        this.auto = auto;
    }

    @Override
    public void initialize(Stage primaryStage) {
        // Sets the window title
        primaryStage.setTitle(getWindowTitle());

        // Create the scene
        setSceneNodes(new Group());
        setGameSurface(new Scene(getSceneNodes(), 850, 850));
        primaryStage.setScene(getGameSurface());

        //adding the pacman


        Board board = new PrimsBoard(40, 30, 20, 1, 1);
        createWall(board, 40, 30, 20);

        pacman = new PacMan(board);
        getSpriteManager().addSprites(pacman);
        getSceneNodes().getChildren().add(pacman.node);
        pacman.node.setTranslateX(30);
        pacman.node.setTranslateY(30);

        if (auto) {
            setInput(primaryStage);
        }

        final Timeline gameLoop = getGameLoop();
    }

    private int numberOfNeighboor(int[][] maze, int width, int height, int x, int y) {
        int number = 0;
        if (x > 0 && maze[x - 1][y] == 1) ++number;
        if (x <= width - 1 && maze[x + 1][y] == 1) ++number;
        if (y > 0 && maze[x][y - 1] == 1) ++number;
        if (y <= height - 1 && maze[x][y + 1] == 1) ++number;
        return number;
    }

    public void createWall(Board board, int width, int height, double size) {
        int[][] maze = board.getBoard();
        int[][] withWall = new int[width + 1][height + 1];
        for (int i = 0; i <= height; ++i) {
            withWall[width][i] = 1;
        }
        for (int i = 0; i < width; ++i) {
            withWall[i][height] = 1;
            for (int j = 0; j < height; ++j) {
                withWall[i][j] = maze[i][j];
            }
        }
        for (int i = 0; i <= width; ++i) {
            for (int j = 0; j <= height; ++j) {
                if (withWall[i][j] == 1) {
                    WallPosition pos = null;
                    int numNeighboor = numberOfNeighboor(withWall, width, height, i, j);
                    switch (numberOfNeighboor(withWall, width, height, i, j)) {
                        case 1:
                            //we need to find wich one
                            if (i > 0 && withWall[i - 1][j] == 1) pos = WallPosition.LEFT;
                            else if (i < width && withWall[i + 1][j] == 1) pos = WallPosition.RIGHT;
                            else if (j > 0 && withWall[i][j - 1] == 1) pos = WallPosition.UP;
                            else if (j < height && withWall[i][j + 1] == 1) pos = WallPosition.DOWN;
                            break;
                        case 2:
                            if (i > 0 && withWall[i - 1][j] == 1) {
                                if (j > 0 && withWall[i][j - 1] == 1) pos = WallPosition.CORNERUPLEFT;
                                else if (j < height && withWall[i][j + 1] == 1) pos = WallPosition.CORNERDOWNLEFT;
                                else pos = WallPosition.HORIZONTAL;
                            } else if (i < width && withWall[i + 1][j] == 1) {
                                if (j > 0 && withWall[i][j - 1] == 1) pos = WallPosition.CORNERUPRIGHT;
                                else if (j < height && withWall[i][j + 1] == 1) pos = WallPosition.CORNERDOWNRIGHT;
                                else pos = WallPosition.HORIZONTAL;
                            } else pos = WallPosition.VERTICAL;
                            break;
                        case 3:
                            if (i <= 0 || withWall[i - 1][j] == 0) pos = WallPosition.TRIGHT;
                            else if (i >= width - 1 || withWall[i + 1][j] == 0) pos = WallPosition.TLEFT;
                            else if (j <= 0 || withWall[i][j - 1] == 0) pos = WallPosition.TDOWN;
                            else if (j >= height - 1 || withWall[i][j + 1] == 0) pos = WallPosition.TUP;
                            break;
                        case 4:
                            pos = WallPosition.CROSS;

                    }
                    addWall(pos, size, i * size + 1, j * size + 1);
                } else if (withWall[i][j] == 2) {
                    addCanva(Color.BLUE, size, i * size + 1, j * size + 1);
                } else if (withWall[i][j] == 3) {
                    addCanva(Color.RED, size, i * size + 1, j * size + 1);
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
        if (sprite instanceof PacMan) {
            PacMan pac = (PacMan) sprite;

            // advance the spheres velocity
            pac.update();

            //there will be wall every where so it gonna be remove
            // bounce off the walls when outside of boundaries
            if (pac.node.getTranslateX() > (getGameSurface().getWidth() - pac.node.getBoundsInParent().getWidth())) {
                pac.node.setTranslateX(getGameSurface().getWidth() - pac.node.getBoundsInParent().getWidth());
            } else if (pac.node.getTranslateX() < 0) {
                pac.node.setTranslateX(0);
            }
            if (pac.node.getTranslateY() > (getGameSurface().getHeight() - pac.node.getBoundsInParent().getHeight())) {
                pac.node.setTranslateY(getGameSurface().getHeight() - pac.node.getBoundsInParent().getHeight());
            } else if (pac.node.getTranslateY() < 0) {
                pac.node.setTranslateY(0);
            }
        }
    }

    @Override
    protected boolean handleCollision(Sprite spriteA, Sprite spriteB) {
        if (spriteA != spriteB) {
            if (spriteA.collide(spriteB)) {
                if (spriteA == pacman) {
                    pacman.stop();
                } else if (spriteB == pacman) {
                    pacman.stop();
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
