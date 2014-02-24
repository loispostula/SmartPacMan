package lpostula.pacman;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    private static PacManWorld gameWorld;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameWorld = new PacManWorld(60, "Pacman", true, 20, 30);
        gameWorld.initialize(primaryStage);
        primaryStage.show();
        gameWorld.beginGameLoope();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
