package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;


public class Controller {

    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField passwordTextField;

    public static void showLoginForm(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Main.class.getResource("login.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root, 300, 275));
        stage.show();
    }

    public void loginButtonOnAction(ActionEvent actionEvent) {
        if (usernameTextField.getText().trim().isEmpty()) {
            System.out.println("Username or password was not inserted!");
        } else if (usernameTextField.getText().equals("admin") && passwordTextField.getText().equals("admin")) {
            try {
                System.out.println("pressed");
                Stage secondStage = new Stage();
                Parent root = FXMLLoader.load(Main.class.getResource("admin.fxml"));
                secondStage.setTitle("Admin");
                secondStage.setScene(new Scene(root, 650, 475));
                secondStage.show();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
            } finally {
                ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
            }
        }
//        scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());

    }
}
