package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;

public class Controller {

    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField passwordTextField;

    public static void showLoginForm(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
        stage.setTitle("Welcome");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }

    public void loginButtonOnAction(ActionEvent actionEvent) {
        if (usernameTextField.getText().trim().isEmpty()) {
            System.out.println("Username or password was not inserted!");
        } else if (usernameTextField.getText().equals("admin") && passwordTextField.getText().equals("admin")) {
            AdminController.showAdminForm(actionEvent);
        }
    }
}
