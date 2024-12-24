package com.hyh.schoolmanagement.Service;

import com.hyh.schoolmanagement.dao.ProfessorDao;
import com.hyh.schoolmanagement.model.Professor;
import com.hyh.schoolmanagement.model.Speciality;

import java.util.List;
import java.util.Optional;

public class ProfessorService {
    private final ProfessorDao professorDao;

    public ProfessorService(ProfessorDao professorDao) {
        this.professorDao = professorDao;
    }

    public List<Professor> getAllProfessors() {
        return professorDao.findAll();
    }

    public Optional<Professor> getProfessorById(Long id) {
        return professorDao.findById(id);
    }

    public List<Professor> getProfessorsBySpeciality(Speciality speciality) {
        return professorDao.findBySpeciality(speciality);
    }

    public void addProfessor(Professor professor) {
        professorDao.save(professor);
    }

    public void updateProfessor(Professor professor) {
        professorDao.update(professor);
    }

    public void deleteProfessor(Long id) {
        professorDao.delete(id);
    }
}
