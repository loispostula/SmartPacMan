package lpostula.pacman;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The type Main.
 */
public class Main extends Application {

    private static PacManWorld gameWorld;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameWorld = new PacManWorld(12, "Pacman", true, 19, 21);
        gameWorld.initialize(primaryStage);
        primaryStage.show();
        gameWorld.beginGameLoope();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
