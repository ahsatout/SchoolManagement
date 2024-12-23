package com.hyh.schoolmanagement.Service;

import com.hyh.schoolmanagement.dao.FiliereDao;
import com.hyh.schoolmanagement.dao.impl.FiliereDaoImpl;
import com.hyh.schoolmanagement.model.Filiere;

import java.util.List;
import java.util.Optional;

public class FiliereService {

    private FiliereDao filiereDao;

    // Constructeur
    public FiliereService() {
        this.filiereDao = new FiliereDaoImpl(); // Initialisation du DAO
    }

    // Ajouter une nouvelle filière
    public void addFiliere(Filiere filiere) {
        // Sauvegarde de la filière dans la base de données via le DAO
        filiereDao.save(filiere);
    }

    // Mettre à jour une filière existante
    public void updateFiliere(Filiere filiere) {
        // Mise à jour de la filière dans la base de données via le DAO
        filiereDao.update(filiere);
    }

    // Supprimer une filière par son ID
    public void deleteFiliere(Long id) {
        // Suppression de la filière de la base de données en utilisant son ID via le DAO
        filiereDao.delete(id);
    }

    // Récupérer une filière par son ID
    public Filiere getFiliereById(Long id) {
        Optional<Filiere> filiereOptional = filiereDao.findById(id);
        return filiereOptional.orElse(null); // Retourne null si la filière n'existe pas
    }

    // Récupérer toutes les filières
    public List<Filiere> getAllFiliere() {
        return filiereDao.findAll(); // Retourne toutes les filières de la base de données
    }

    // Rechercher des filières par nom
    public List<Filiere> searchFiliereByName(String name) {
        return filiereDao.findBy("name", name); // Recherche des filières par nom
    }


}
