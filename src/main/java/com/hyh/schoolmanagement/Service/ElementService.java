package com.hyh.schoolmanagement.Service;

import com.hyh.schoolmanagement.dao.ElementDao;
import com.hyh.schoolmanagement.dao.ModuleDao;
import com.hyh.schoolmanagement.dao.ProfessorDao;
import com.hyh.schoolmanagement.dao.impl.ElementDaoImpl;
import com.hyh.schoolmanagement.dao.impl.ModuleDaoImpl;
import com.hyh.schoolmanagement.dao.impl.ProfessorDaoImpl;
import com.hyh.schoolmanagement.model.Element;

import java.util.List;
import java.util.Optional;

public class ElementService {

    private final ElementDao elementDao;

    public ElementService(ElementDao elementDao) {
        this.elementDao = elementDao;
    }

    /**
     * Trouve un élément par son ID.
     *
     * @param id L'ID de l'élément.
     * @return Un Optional contenant l'élément s'il existe, ou vide sinon.
     */
    public Optional<Element> findById(Long id) {
        return elementDao.findById(id);
    }

    /**
     * Récupère tous les éléments.
     *
     * @return Une liste de tous les éléments.
     */
    public List<Element> findAll() {
        return elementDao.findAll();
    }

    /**
     * Crée ou met à jour un élément.
     *
     * @param element L'élément à sauvegarder.
     * @return L'élément sauvegardé.
     */
    public void save(Element element) {
        validateElement(element);
        elementDao.save(element);
    }

    /**
     * Met à jour un élément existant.
     *
     * @param element L'élément à mettre à jour.
     */
    public void update(Element element) {
        validateElement(element);
        elementDao.update(element);
    }

    /**
     * Supprime un élément par son ID.
     *
     * @param id L'ID de l'élément à supprimer.
     */
    public void delete(Long id) {
        elementDao.delete(id);
    }

    /**
     * Trouve les éléments associés à un professeur spécifique.
     *
     * @param professorId L'ID du professeur.
     * @return Une liste des éléments associés.
     */
    public List<Element> findElementsByProfessorId(Long professorId) {
        return elementDao.findElementsByProfessorId(professorId);
    }

    /**
     * Valide les données d'un élément avant de le sauvegarder ou le mettre à jour.
     *
     * @param element L'élément à valider.
     */
    private void validateElement(Element element) {
        if (element.getName() == null || element.getName().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'élément ne peut pas être vide.");
        }
        if (element.getCoefficient() <= 0) {
            throw new IllegalArgumentException("Le coefficient doit être supérieur à 0.");
        }
    }

}
