package src.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class Controller {
    @FXML
    public Button loginButton;
    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField passwordTextField;

    public void loginButtonOnAction(){
        System.out.println("pressed");
        loginButton.setText("Hey baby");
    }

    public void handleCancelAction(ActionEvent actionEvent){
        System.out.println("pressed");
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.close();

        loginButton.setText("Hey baby");
    }
}
