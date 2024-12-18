package com.hyh.schoolmanagement.model;

import com.hyh.schoolmanagement.annotation.Column;
import com.hyh.schoolmanagement.annotation.Table;

@Table(name = "module")
public class Module implements Identifiable {

    @Column(name = "id", type = "INTEGER", primaryKey = true)
    private Long id;

    @Column(name = "name", type = "VARCHAR(255)")
    private String name;

    // Many-To-One relationship with Filiere
    @Column(name = "filiere_id", type = "INTEGER", foreignKey = "filiere(id)")
    private Filiere filiere;

    // Many-To-One relationship with Semester
    @Column(name = "semester", type = "VARCHAR(2)")
    private Semester semester;
    public Module() { }
    public Module(Long id, String name, Filiere filiere, Semester semester) {
        super();
        this.id = id;
        this.name = name;
        this.filiere = filiere;
        this.semester = semester;
    }

    public Module(String name, Filiere filiere, Semester semester) {
        super();
        this.name = name;
        this.filiere = filiere;
        this.semester = semester;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Module [id=" + id + ", name=" + name + ", filiere=" + filiere
                + ", semester=" + semester + "]";
    }
}
