package sample;

import controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller.showLoginForm(primaryStage);
    }

}

