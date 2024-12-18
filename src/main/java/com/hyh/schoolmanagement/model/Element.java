package com.hyh.schoolmanagement.model;

import com.hyh.schoolmanagement.annotation.Column;
import com.hyh.schoolmanagement.annotation.Table;

import java.util.List;

@Table(name="Element")
public class Element implements Identifiable {

	@Column(name = "id", type = "INTEGER", primaryKey = true)
	private Long id;
	@Column(name = "name", type = "VARCHAR(255)")

	private String name;

	@Column(name = "coefficient", type = "DOUBLE")
	private double coefficient;
	private List<EvaluationMethod> evaluationMethods;
	@Column(name = "module_id", type = "INTEGER", foreignKey = "module(id)")
	private Module module;

	@Column(name = "professor_id", type = "INTEGER", foreignKey = "professor(id)")
	private Professor professor;

	public Element(String name, double coefficient, Module module, Professor professor) {}

	public Element(long id, String name, double coefficient,
                   List<EvaluationMethod> evaluationMethods, Module module,
                   Professor professor) {
		super();
		this.id = id;
		this.name = name;
		this.coefficient = coefficient;
		this.evaluationMethods = evaluationMethods;
		this.module = module;
		this.professor = professor;
	}

	public Element(String name, double coefficient,
                   List<EvaluationMethod> evaluationMethods, Module module,
                   Professor professor) {
		super();
		this.name = name;
		this.coefficient = coefficient;
		this.evaluationMethods = evaluationMethods;
		this.module = module;
		this.professor = professor;
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

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public List<EvaluationMethod> getEvaluationMethods() {
		return evaluationMethods;
	}

	public void setEvaluationMethods(List<EvaluationMethod> evaluationMethods) {
		this.evaluationMethods = evaluationMethods;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

}
