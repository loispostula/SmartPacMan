package lpostula;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by lpostula on 16/02/14.
 * Documentation de la classe Main
 */
public class MainChooser extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("optionChooser/optionChooser.fxml"));
        Scene scene = new Scene(root);

        stage.setTitle("Option");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
