package com.hyh.schoolmanagement.model;

import java.util.ArrayList;
import java.util.List;

public class Filiere implements Entity {
    private Long id;
    private String name;
    private String acronym;
    private List<Module> modules;

    public Filiere(String name, String acronym) {
        this.name = name;
        this.acronym = acronym;
    }

    public Filiere(Long id, String name, String acronym) {
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Ajout d'un module à la liste
    public void addModule(Module module) {
        modules.add(module);
        module.setFiliere(this);
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Module> getModules() {
        return modules;
    }

    @Override
    public String toString() {
        return "Filiere [id=" + id + ", name=" + name + ", acronym=" + acronym + "]";
    }
}
