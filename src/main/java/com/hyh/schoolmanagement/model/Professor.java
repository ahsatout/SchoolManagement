package com.hyh.schoolmanagement.model;

import com.hyh.schoolmanagement.annotation.Column;
import com.hyh.schoolmanagement.annotation.OneToMany;
import com.hyh.schoolmanagement.annotation.Table;

import java.util.List;

@Table(name="Professeur")
public class Professor implements Identifiable {

	@Column(name = "id", type = "BIGINT", primaryKey = true)
	private Long id;
	@Column(name = "firstname", type = "VARCHAR(255)")
	private String firstName;
	@Column(name = "lastname", type = "VARCHAR(255)")
	private String lastName;
	@Column(name = "password", type = "VARCHAR(255)")

	private Speciality speciality;

	private List<Element> elements;

	public Professor(Long id, String firstName, String lastName, Speciality speciality) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.speciality = speciality;
	}

	public Professor(Long id, String firstName, String lastName, String speciality) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.speciality = new Speciality(speciality);
	}

	public Professor(String firstName, String lastName, String speciality) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.speciality = new Speciality(speciality);
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", speciality=" + speciality + "]";
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}

	public void addElement(Element element) {
		elements.add(element);
		element.setProfessor(this);
	}

	@Override
	public boolean equals(Object o) {
		Professor p = (Professor) o;

		if (p.getFirstName().equals(getFirstName()) &&
				p.getLastName().equals(getLastName()) &&
				p.getSpeciality().getName().equals(getSpeciality().getName())) {
			return true;
		} else
			return false;
	}

}
