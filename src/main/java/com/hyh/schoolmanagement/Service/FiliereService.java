package com.hyh.schoolmanagement.Service;

import com.hyh.schoolmanagement.dao.FiliereDao;
import com.hyh.schoolmanagement.model.Filiere;

import java.util.List;
import java.util.Optional;

public class FiliereService {

    private final FiliereDao filiereDao;

    public FiliereService(FiliereDao filiereDao) {
        this.filiereDao = filiereDao;
    }

    public List<Filiere> getAllFilieres() {
        return filiereDao.findAll();
    }

    public Optional<Filiere> getFiliereById(Long id) {
        return filiereDao.findById(id);
    }

    public void addFiliere(Filiere filiere) {
        filiereDao.save(filiere);
    }

    public void updateFiliere(Filiere filiere) {
        filiereDao.update(filiere);
    }

    public void deleteFiliere(Long id) {
        filiereDao.delete(id);
    }
}
