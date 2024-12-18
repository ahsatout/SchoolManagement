package com.hyh.schoolmanagement.model;

import com.hyh.schoolmanagement.annotation.Column;
import com.hyh.schoolmanagement.annotation.Table;

@Table(name = "speciality")
public class Speciality {
	@Column(name = "id", type = "INTEGER", primaryKey = true)
	private Long id;

	@Column(name = "name", type = "VARCHAR(255)")
	private String name;

	public Speciality() { }
	public Speciality(String name) {
		super();
		this.name = name;
	}

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

}