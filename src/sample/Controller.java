package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    public Button loginButton;
    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField passwordTextField;

    public void loginButtonOnAction(ActionEvent actionEvent){
        System.out.println("pressed");
        if (usernameTextField.getText().trim().isEmpty()) {
            System.out.println("-1-");
        } else {
            System.out.println("-2-");
        }

        loginButton.setText("Hey baby");
    }
}
