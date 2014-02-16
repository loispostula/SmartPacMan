package lpostula.pacman;

import javafx.application.Application;
import javafx.stage.Stage;

public class pacmanApp extends Application {

    private static PacManWorld gameWorld;

    public pacmanApp(int col, int row) {
        gameWorld = new PacManWorld(60, "Pacman", true, col, row);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameWorld.initialize(primaryStage);
        primaryStage.show();
    }

    public static void begin() {
        gameWorld.beginGameLoope();
    }
}
