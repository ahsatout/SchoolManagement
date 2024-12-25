import com.hyh.schoolmanagement.Service.ElementService;
import com.hyh.schoolmanagement.dao.ElementDao;
import com.hyh.schoolmanagement.model.Element;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class  ElementServiceTest {

    private ElementDao elementDaoMock;
    private ElementService elementService;

    @BeforeEach
    void setUp() {
        // Créer un mock pour le DAO
        elementDaoMock = mock(ElementDao.class);

        // Créer une instance de ElementService en injectant le mock du DAO
        elementService = new ElementService(elementDaoMock);
    }

    @Test
    void testFindById() {
        // Création d'un élément mocké
        Element mockElement = new Element("Mathématiques", 3.0, null, null, null);
        mockElement.setId(1L);

        // Comportement attendu du mock : quand on appelle findById avec un ID, renvoie l'élément
        when(elementDaoMock.findById(1L)).thenReturn(Optional.of(mockElement));

        // Tester la méthode findById
        Optional<Element> foundElement = elementService.findById(1L);
        assertTrue(foundElement.isPresent());
        assertEquals(1L, foundElement.get().getId());
        assertEquals("Mathématiques", foundElement.get().getName());

        // Vérification du comportement du mock
        verify(elementDaoMock, times(1)).findById(1L);
    }

    @Test
    void testFindAll() {
        // Créer des éléments mockés
        Element mockElement1 = new Element("Mathématiques", 3.0, null, null, null);
        mockElement1.setId(1L);
        Element mockElement2 = new Element("Informatique", 4.0, null, null, null);
        mockElement2.setId(2L);

        // Comportement attendu du mock : quand on appelle findAll, renvoie la liste des éléments
        when(elementDaoMock.findAll()).thenReturn(Arrays.asList(mockElement1, mockElement2));

        // Tester la méthode findAll
        List<Element> elements = elementService.findAll();
        assertEquals(2, elements.size());
        assertEquals("Mathématiques", elements.get(0).getName());
        assertEquals("Informatique", elements.get(1).getName());

        // Vérification du comportement du mock
        verify(elementDaoMock, times(1)).findAll();
    }

    @Test
    void testSave_validElement() {
        // Création d'un élément valide à sauvegarder
        Element mockElement = new Element("Physique", 2.0, null, null, null);
        mockElement.setId(3L);

        // Comportement attendu du mock : sauvegarder un élément
        doNothing().when(elementDaoMock).save(mockElement);

        // Tester la méthode save
        elementService.save(mockElement);

        // Vérification que save a bien été appelé
        verify(elementDaoMock, times(1)).save(mockElement);
    }

    @Test
    void testSave_invalidElementName() {
        // Création d'un élément avec un nom invalide (vide)
        Element mockElement = new Element("", 2.0, null, null, null);

        // Vérifier que l'exception est lancée pour un nom vide
        assertThrows(IllegalArgumentException.class, () -> elementService.save(mockElement));
    }

    @Test
    void testSave_invalidElementCoefficient() {
        // Création d'un élément avec un coefficient invalide (<= 0)
        Element mockElement = new Element("Chimie", -1.0, null, null, null);

        // Vérifier que l'exception est lancée pour un coefficient <= 0
        assertThrows(IllegalArgumentException.class, () -> elementService.save(mockElement));
    }

    @Test
    void testUpdate() {
        // Création d'un élément mocké à mettre à jour
        Element mockElement = new Element("Chimie", 2.5, null, null, null);
        mockElement.setId(4L);

        // Comportement attendu du mock : mettre à jour un élément
        doNothing().when(elementDaoMock).update(mockElement);

        // Tester la méthode update
        elementService.update(mockElement);

        // Vérification que update a bien été appelé
        verify(elementDaoMock, times(1)).update(mockElement);
    }

    @Test
    void testDelete() {
        // Créer un élément mocké avec un ID
        Long elementId = 5L;

        // Comportement attendu du mock : supprimer un élément
        doNothing().when(elementDaoMock).delete(elementId);

        // Tester la méthode delete
        elementService.delete(elementId);

        // Vérification que delete a bien été appelé
        verify(elementDaoMock, times(1)).delete(elementId);
    }

    @Test
    void testFindElementsByProfessorId() {
        // Création d'un élément associé à un professeur
        Element mockElement1 = new Element("Mathématiques", 3.0, null, null, null);
        mockElement1.setId(1L);
        Element mockElement2 = new Element("Informatique", 4.0, null, null, null);
        mockElement2.setId(2L);

        // Créer un ID de professeur mocké
        Long professorId = 101L;

        // Comportement attendu du mock : trouver les éléments associés au professeur
        when(elementDaoMock.findElementsByProfessorId(professorId))
                .thenReturn(Arrays.asList(mockElement1, mockElement2));

        // Tester la méthode findElementsByProfessorId
        List<Element> elements = elementService.findElementsByProfessorId(professorId);
        assertEquals(2, elements.size());
        assertEquals("Mathématiques", elements.get(0).getName());
        assertEquals("Informatique", elements.get(1).getName());

        // Vérification du comportement du mock
        verify(elementDaoMock, times(1)).findElementsByProfessorId(professorId);
    }
}
