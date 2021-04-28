package model;

public class Patient {
    public String name;
    public String section;
    public String diagnostic;
    public int status;

    public Patient(String name, String section, String diagnostic, int status) {
        this.name = name;
        this.section = section;
        this.diagnostic = diagnostic;
        this.status = status;
    }
}
