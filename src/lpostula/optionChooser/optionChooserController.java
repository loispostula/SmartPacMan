package lpostula.optionChooser;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lpostula.pacman.pacmanApp;

import java.net.URL;
import java.util.ResourceBundle;

public class optionChooserController implements Initializable {

    @FXML
    private Button buttonGenerate;

    @FXML
    private Button buttonStart;

    @FXML
    private TextField columnField;

    @FXML
    private TextField rowField;

    @FXML
    private Label label;

    private pacmanApp app;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonGenerate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                int column = new Integer(columnField.getText());
                int row = new Integer(rowField.getText());
                app = new pacmanApp(column, row);
                Stage stage = new Stage();
                try {
                    app.start(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        buttonStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                pacmanApp.begin();
            }
        });
    }
}