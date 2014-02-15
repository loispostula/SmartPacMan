package lpostula;

import javafx.application.Application;
import javafx.stage.Stage;
import lpostula.gameengine.GameWorld;
import lpostula.pacman.PacManWorld;

public class Main extends Application {

    GameWorld gameWorld = new PacManWorld(60, "Pacman");

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameWorld.initialize(primaryStage);
        gameWorld.beginGameLoope();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
