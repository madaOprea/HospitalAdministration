package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Patient;

public class AdminController  {

    @FXML private Button addPatientButton;
    @FXML private Button editPatientButton;
    @FXML private Button deletePatientButton;

    @FXML private TableView<Patient> tableWithAllPatients;
    @FXML private TableColumn<Patient, String> nameColumn;
    @FXML private TableColumn<Patient, String> sectionColumn;
    @FXML private TableColumn<Patient, String> diagnosticColumn;
    @FXML private TableColumn<Patient, String> statusColumn;

    public void addPatientOnAction(){

    }

    public void editPatientOnAction(){

    }

    public void deletePatientOnAction(){

    }

    public void showData() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().namePatient);
        sectionColumn.setCellValueFactory(cellData -> cellData.getValue().sectionPatient);
        diagnosticColumn.setCellValueFactory(cellData -> cellData.getValue().diagnosticPatient);
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusPatient);

        tableWithAllPatients.getItems().addAll(
                new Patient("Jacob", "Smith", "jacob.smith@example.com", "0"),
                new Patient("Isabella", "Johnson", "isabella.johnson@example.com", "1"),
                new Patient("Ethan", "Williams", "ethan.williams@example.com", "1"),
                new Patient("Emma", "Jones", "emma.jones@example.com", "1"),
                new Patient("Michael", "Brown", "michael.brown@example.com", "1")
        );

        for (Patient patient : tableWithAllPatients.getItems()) {
            String formatted = String.format("%s %s (%s)", patient.getNamePatient(), patient.getSectionPatient(), patient.getDiagnosticPatient(), patient.getStatusPatient());
            System.out.println(formatted);
        }
    }

}
