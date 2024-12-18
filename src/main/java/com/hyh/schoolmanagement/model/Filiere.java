package com.hyh.schoolmanagement.model;

import com.hyh.schoolmanagement.annotation.Column;

import java.util.ArrayList;
import java.util.List;

public class Filiere implements Identifiable {
    @Column(name = "id", type = "INTEGER", primaryKey = true)
    private Long id;
    @Column(name = "name", type = "VARCHAR(10)")
    private String name;
    @Column(name = "acronym", type = "VARCHAR(6)")
    private String acronym;
    List<Module> modules = new ArrayList<>();

    public Filiere() { }

    public Filiere(String name, String acronym) {
        super();
        this.name = name;
        this.acronym = acronym;
    }

    public Filiere(Long id, String name, String acronym) {
        super();
        this.id = id;
        this.name = name;
        this.acronym = acronym;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
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

    public void addModule(Module module) {
        modules.add(module);
        module.setFiliere(this);
    }

    @Override
    public String toString() {
        return "Filiere [id=" + id + ", name=" + name + ", acronym=" + acronym + "]";
    }

}
