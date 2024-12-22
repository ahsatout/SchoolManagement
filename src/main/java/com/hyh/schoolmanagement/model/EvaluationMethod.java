package com.hyh.schoolmanagement.model;

import java.util.Objects;

public class EvaluationMethod {
    private long id;
    private String name;
    private double coefficient;

    // Constructeur par défaut
    public EvaluationMethod() {}

    // Constructeur avec paramètres
    public EvaluationMethod(long id, String name, double coefficient) {
        this.id = id;
        this.name = name;
        this.coefficient = coefficient;
    }

    // Getters et Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    // Méthode toString pour une représentation sous forme de chaîne
    @Override
    public String toString() {
        return "EvaluationMethod [id=" + id + ", name=" + name + ", coefficient=" + coefficient + "]";
    }

    // Méthode equals pour comparer deux objets EvaluationMethod
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        EvaluationMethod that = (EvaluationMethod) obj;
        return id == that.id &&
                Double.compare(that.coefficient, coefficient) == 0 &&
                name.equals(that.name);
    }

    // Méthode hashCode pour générer un code de hachage basé sur id, name et coefficient
    @Override
    public int hashCode() {
        return Objects.hash(id, name, coefficient);
    }
}
