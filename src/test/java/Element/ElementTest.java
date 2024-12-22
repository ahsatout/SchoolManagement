package com.hyh.schoolmanagement.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    private Element element;
    private Module module;
    private Professor professor;
    private List<EvaluationMethod> evaluationMethods;

    @BeforeEach
    void setUp() {
        // Initialisation du module
        Filiere filiere = new Filiere(1L, "Info et Ing des Données", "IID");
        module = new Module(1L, "Java", filiere, Semester.S1);

        // Initialisation du professeur
        professor = new Professor(1L, "Noureddine", "GHERABI", "Java");

        // Initialisation des méthodes d'évaluation
        evaluationMethods = new ArrayList<>();
        evaluationMethods.add(new EvaluationMethod(1L, "Exam", 0.6));
        evaluationMethods.add(new EvaluationMethod(2L, "Project", 0.4));

        // Initialisation de l'élément
        element = new Element(1L, "Basics of Java", 2.5, evaluationMethods, module, professor);
    }

    @Test
    void testConstructorWithAllFields() {
        assertNotNull(element);
        assertEquals(1L, element.getId());
        assertEquals("Basics of Java", element.getName());
        assertEquals(2.5, element.getCoefficient());
        assertEquals(evaluationMethods, element.getEvaluationMethods());
        assertEquals(module, element.getModule());
        assertEquals(professor, element.getProfessor());
    }

    @Test
    void testConstructorWithoutId() {
        Element elementWithoutId = new Element("Jee", 3.0, evaluationMethods, module, professor);

        assertNull(elementWithoutId.getId());
        assertEquals("Jee", elementWithoutId.getName());
        assertEquals(3.0, elementWithoutId.getCoefficient());
        assertEquals(evaluationMethods, elementWithoutId.getEvaluationMethods());
        assertEquals(module, elementWithoutId.getModule());
        assertEquals(professor, elementWithoutId.getProfessor());
    }

    @Test
    void testConstructorWithoutEvaluationMethods() {
        Element elementWithoutEvalMethods = new Element("Oracle DB", 4.0, module, professor);

        assertNull(elementWithoutEvalMethods.getId());
        assertEquals("Oracle DB", elementWithoutEvalMethods.getName());
        assertEquals(4.0, elementWithoutEvalMethods.getCoefficient());
        assertNull(elementWithoutEvalMethods.getEvaluationMethods());
        assertEquals(module, elementWithoutEvalMethods.getModule());
        assertEquals(professor, elementWithoutEvalMethods.getProfessor());
    }

    @Test
    void testSettersAndGetters() {
        element.setName("Machine Learning");
        element.setCoefficient(5.0);
        element.setEvaluationMethods(new ArrayList<>());
        element.setModule(new Module(2L, "AI", new Filiere(2L, "Info et Ing des données", "IID"), Semester.S2));
        element.setProfessor(new Professor(2L, "Hamza", "El khalfi", "AI"));

        assertEquals("Machine Learning", element.getName());
        assertEquals(5.0, element.getCoefficient());
        assertTrue(element.getEvaluationMethods().isEmpty());
        assertEquals("AI", element.getModule().getName());
        assertEquals("Hamza", element.getProfessor().getFirstName());
        assertEquals("El khalfi", element.getProfessor().getLastName());
    }
/*
    @Test
    void testToString() {
        String expected = "Element [id=1, name=Algebra, coefficient=2.5, module=Module [id=1, name=Mathematics, filiere=Filiere [id=1, name=Science, acronym=SCI], semester=FIRST], professor=Professor [id=1, firstName=John, lastName=Doe, speciality=Mathematics]]";
        assertEquals(expected, element.toString());
    }
*/
    @Test
    void testProfessorEquality() {
        Professor newProfessor = new Professor("Noureddine", "GHERABI", "Java");
        assertTrue(professor.equals(newProfessor));

        Professor differentProfessor = new Professor("Hamza", "El khalfi", "AI");
        assertFalse(professor.equals(differentProfessor));
    }
}
