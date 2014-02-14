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
        setInputPacMan(primaryStage);

        final Timeline gameLoop = getGameLoop();
    }

    @Override
    protected void handleUpdate(Sprite sprite) {
        if (sprite instanceof PacMan) {
            PacMan pac = (PacMan) sprite;

            // advance the spheres velocity
            pac.update();

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

    final private void setInputPacMan(Stage primaryStage) {
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
