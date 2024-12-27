package com.hyh.schoolmanagement.model;

public class Module implements Entity {
    private Long id;
    private String name;
    private Filiere filiere;
    private Semester semester;

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    // Constructeur par défaut
    public Module() {}

    // Constructeur avec id et name
    public Module(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters et setters
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

    @Override
    public String toString() {
        return "Module [id=" + id + ", name=" + name + "]";
    }
}
