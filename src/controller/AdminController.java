package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Patient;

public class AdminController  {

    @FXML private TableView<Patient> tableWithAllPatients;
    @FXML private TableColumn<Patient, String> nameColumn;
    @FXML private TableColumn<Patient, String> sectionColumn;
    @FXML private TableColumn<Patient, String> diagnosticColumn;
    @FXML private TableColumn<Patient, String> statusColumn;

    @FXML private Button addPatientButton;
    @FXML private Button editPatientButton;
    @FXML private Button deletePatientButton;

    @FXML private TextField newPatientNameTextField;
    @FXML private ChoiceBox newPatientSectionChoiceBox;
    @FXML private TextArea newPatientDiagnosticTextArea;

    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().namePatient);
        sectionColumn.setCellValueFactory(cellData -> cellData.getValue().sectionPatient);
        diagnosticColumn.setCellValueFactory(cellData -> cellData.getValue().diagnosticPatient);
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusPatient);

        tableWithAllPatients.getItems().addAll(
                new Patient("Jacob", "Gastroenterology", "cured", "0"),
                new Patient("Isabella", "Cardiology", "cured", "1"),
                new Patient("Ethan", "Gastroenterology", "cured", "1"),
                new Patient("Emma", "Surgery", "cured", "1"),
                new Patient("Michael", "Gastroenterology", "cured", "1")
        );
        tableWithAllPatients.setEditable(true);
        tableWithAllPatients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    private void showData() {
        for (Patient patient : tableWithAllPatients.getItems()) {
            String formatted = String.format("%s %s (%s)", patient.getNamePatient(), patient.getSectionPatient(), patient.getDiagnosticPatient(), patient.getStatusPatient());
            System.out.println(formatted);
        }
        System.out.println();
    }

    public void addPatientOnAction(ActionEvent actionEvent) {
        Patient patient = new Patient(newPatientNameTextField.getText(),
                newPatientSectionChoiceBox.getSelectionModel().getSelectedItem().toString(),
                newPatientDiagnosticTextArea.getText(),
                "0");
        tableWithAllPatients.getItems().add(patient);
        clearData();
    }

    public void editPatientOnAction() {
    }

    public void deletePatientOnAction() {
        tableWithAllPatients.getItems().remove(tableWithAllPatients.getSelectionModel().getSelectedItem());
    }

    public void clearData() {
        newPatientNameTextField.setText("");
        // TO DO: clear for choicebox
        newPatientDiagnosticTextArea.setText("");
    }
}
