package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import model.Patient;

public class AdminController {

    @FXML
    private Button addPatientButton;

    @FXML
    private Button editPatientButton;

    @FXML
    private Button deletePatientButton;

    @FXML
    private TableView tableView;

    public void loadingPatients() {
        final ObservableList<Patient> data = FXCollections.observableArrayList(
                new Patient("Jacob", "Smith", "jacob.smith@example.com", 0),
                new Patient("Isabella", "Johnson", "isabella.johnson@example.com", 1),
                new Patient("Ethan", "Williams", "ethan.williams@example.com", 0),
                new Patient("Emma", "Jones", "emma.jones@example.com", 2),
                new Patient("Michael", "Brown", "michael.brown@example.com", 2)
        );
        tableView.setItems(data);
    }

    public void addPatientOnAction(){

    }

    public void editPatientOnAction(){

    }

    public void deletePatientOnAction(){

    }
}
