package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Patient;
import sample.Main;

import java.io.FileNotFoundException;
import java.io.IOException;

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

    public AdminController() {

    }

    public static void showAdminForm(ActionEvent actionEvent) {
        try {
            Stage secondStage = new Stage();
            Parent root = FXMLLoader.load(Main.class.getResource("/sample/admin.fxml"));
            secondStage.setTitle("Admin");
            secondStage.setScene(new Scene(root, 650, 475));
            secondStage.show();
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        } finally {
            ((Node) (actionEvent.getSource())).getScene().getWindow().hide();
        }
//        nameColumn.setCellValueFactory(cellData -> cellData.getValue().namePatient);
//        sectionColumn.setCellValueFactory(cellData -> cellData.getValue().sectionPatient);
//        diagnosticColumn.setCellValueFactory(cellData -> cellData.getValue().diagnosticPatient);
//        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusPatient);
//
//        tableWithAllPatients.getItems().addAll(
//                new Patient("Jacob", "Gastroenterology", "cured", "0"),
//                new Patient("Isabella", "Cardiology", "cured", "1"),
//                new Patient("Ethan", "Gastroenterology", "cured", "1"),
//                new Patient("Emma", "Surgery", "cured", "1"),
//                new Patient("Michael", "Gastroenterology", "cured", "1")
//        );
//        try {
//            System.out.println("hey hey hey");
//            SessionFactory factory = new Configuration()
//                    .configure("hibernate.cfg.xml")
//                    .addAnnotatedClass(PatientsEntity.class)
//                    .buildSessionFactory();
//            System.out.println("bla hey hey");
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//            session.save(new PatientsEntity(newPatientNameTextField.getText(),
//                    newPatientSectionChoiceBox.getSelectionModel().getSelectedItem().toString(),
//                    newPatientDiagnosticTextArea.getText(), "1"));
//            session.getTransaction().commit();
//
//            tableWithAllPatients.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//
//            tableWithAllPatients.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) ->
//            {
//                if (newValue != null) {
//                    newPatientNameTextField.setText(newValue.getNamePatient());
//                    newPatientSectionChoiceBox.setValue(newValue.getSectionPatient());
//                    newPatientDiagnosticTextArea.setText(newValue.getDiagnosticPatient());
//                }
//            });
//        } catch (HibernateException hibernateException) {
//            hibernateException.printStackTrace();
//        }
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
