package lpostula.pacman;

import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import lpostula.gameengine.GameWorld;
import lpostula.gameengine.Sprite;
import lpostula.pacman.wall.Wall;
import lpostula.pacman.wall.WallFactory;
import lpostula.pacman.wall.WallPosition;

/**
 * Created by lpostula on 14/02/14.
 * Documentation de la classe PacManWorld
 */
public class PacManWorld extends GameWorld {

    final PacMan pacman = new PacMan();

    public PacManWorld(int fps, String title) {
        super(fps, title);
    }

    @Override
    public void initialize(Stage primaryStage) {
        // Sets the window title
        primaryStage.setTitle(getWindowTitle());

        // Create the scene
        setSceneNodes(new Group());
        setGameSurface(new Scene(getSceneNodes(), 400, 400));
        primaryStage.setScene(getGameSurface());

        //adding the pacman
        getSpriteManager().addSprites(pacman);
        getSceneNodes().getChildren().add(0, pacman.node);


        addWall(WallPosition.CORNERUPLEFT, 20, 120, 120);
        addWall(WallPosition.CORNERUPRIGHT, 20, 100, 120);
        addWall(WallPosition.CORNERDOWNRIGHT, 20, 100, 100);
        addWall(WallPosition.CORNERDOWNLEFT, 20, 120, 100);
        setInput(primaryStage);

        final Timeline gameLoop = getGameLoop();
    }

    private void addWall(WallPosition position, double width, double posX, double posY) {
        Wall wall = WallFactory.buildWall(position, width, posX, posY);
        getSpriteManager().addSprites(wall);
        getSceneNodes().getChildren().add(0, wall.node);
        wall.node.setTranslateX(posX);
        wall.node.setTranslateY(posY);
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
