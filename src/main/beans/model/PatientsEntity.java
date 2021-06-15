package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "patients", schema = "hospitaladministration", catalog = "")
public class PatientsEntity {
    private int id;
    private String name;
    private String section;
    private String diagnostic;
    private String status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "section")
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Basic
    @Column(name = "diagnostic")
    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientsEntity that = (PatientsEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(section, that.section) && Objects.equals(diagnostic, that.diagnostic) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, section, diagnostic, status);
    }
}
