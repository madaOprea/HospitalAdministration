module HospitalAdministration {

    opens sample;
    opens controller;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    exports sample;
}