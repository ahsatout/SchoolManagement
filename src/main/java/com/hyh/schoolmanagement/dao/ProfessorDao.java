package com.hyh.schoolmanagement.dao;

import com.hyh.schoolmanagement.model.Professor;
import com.hyh.schoolmanagement.model.Speciality;


import java.util.List;

public interface ProfessorDao extends Dao<Professor> {
	List<Professor> findBySpeciality(Speciality speciality);
}
