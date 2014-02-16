package lpostula;

import javafx.application.Application;
import javafx.stage.Stage;
import lpostula.pacman.PacManWorld;

public class Main extends Application {

    PacManWorld gameWorld = new PacManWorld(100, "Pacman", true);

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
