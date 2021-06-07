package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Patient {
    public StringProperty namePatient = new SimpleStringProperty(this, "nameColumn");
    public StringProperty sectionPatient = new SimpleStringProperty(this, "sectionColumn");
    public StringProperty diagnosticPatient = new SimpleStringProperty(this, "diagnosticColumn");
    public StringProperty statusPatient = new SimpleStringProperty(this, "statusColumn");

    public Patient(String name, String section, String diagnostic, String status) {
        this.setNamePatient(name);
        this.setSectionPatient(section);
        this.setDiagnosticPatient(diagnostic);
        this.setStatusPatient(status);
    }

    public String getNamePatient() {
        return namePatientProperty().get();
    }

    public StringProperty namePatientProperty() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        namePatientProperty().set(namePatient);
    }

    public String getSectionPatient() {
        return sectionPatientProperty().get();
    }

    public StringProperty sectionPatientProperty() {
        return sectionPatient;
    }

    public void setSectionPatient(String sectionPatient) {
        sectionPatientProperty().set(sectionPatient);
    }

    public String getDiagnosticPatient() {
        return diagnosticPatientProperty().get();
    }

    public StringProperty diagnosticPatientProperty() {
        return diagnosticPatient;
    }

    public void setDiagnosticPatient(String diagnosticPatient) {
        diagnosticPatientProperty().set(diagnosticPatient);
    }

    public String getStatusPatient() {
        return statusPatientProperty().get();
    }

    public StringProperty statusPatientProperty() {
        return statusPatient;
    }

    public void setStatusPatient(String statusPatient) {
        statusPatientProperty().set(statusPatient);
    }
}
