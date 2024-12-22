package com.hyh.schoolmanagement.model;

public class Speciality {
    private String name;

    public Speciality(String name) {
        super();
        this.name = name;
    }
    public Speciality(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Speciality [name=" + name + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Speciality speciality = (Speciality) obj;
        return name != null ? name.equals(speciality.name) : speciality.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

}
