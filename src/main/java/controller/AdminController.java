package main.java.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.java.model.Patient;

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

        tableWithAllPatients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//inner

        tableWithAllPatients.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) ->
        {
            if (newValue != null) {
                newPatientNameTextField.setText(newValue.getNamePatient());
                newPatientSectionChoiceBox.setValue(newValue.getSectionPatient());
                newPatientDiagnosticTextArea.setText(newValue.getDiagnosticPatient());
            }
        });
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
        if (validateFields() == true) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("The patient name or the diagnostic is empty!");
        } else {
            Patient patientSelectedToBeEdited = tableWithAllPatients.getSelectionModel().getSelectedItem();
            Patient editedPatient = new Patient(newPatientNameTextField.getText(),
                    newPatientSectionChoiceBox.getSelectionModel().getSelectedItem().toString(),
                    newPatientDiagnosticTextArea.getText(),
                    patientSelectedToBeEdited.getStatusPatient());
            tableWithAllPatients.getItems().remove(patientSelectedToBeEdited);
            tableWithAllPatients.getItems().add(editedPatient);
            clearData();
        }
    }

    public void deletePatientOnAction() {
        tableWithAllPatients.getItems().remove(tableWithAllPatients.getSelectionModel().getSelectedItem());
    }

    private void clearData() {
        newPatientNameTextField.setText("");
        // TO DO: clear for choicebox
        newPatientDiagnosticTextArea.setText("");
    }

    private boolean validateFields() {
        return newPatientNameTextField.getText().isEmpty() || newPatientDiagnosticTextArea.getText().isEmpty() ? true : false;
    }
}
