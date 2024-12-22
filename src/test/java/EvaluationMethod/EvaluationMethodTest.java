package com.hyh.schoolmanagement.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationMethodTest {

    private EvaluationMethod evaluationMethod;

    @BeforeEach
    void setUp() {
        // Initialisation de l'objet EvaluationMethod avant chaque test
        evaluationMethod = new EvaluationMethod();
        evaluationMethod.setId(1L);
        evaluationMethod.setName("Exam");
        evaluationMethod.setCoefficient(2.5);
    }

    @Test
    void testConstructor() {
        EvaluationMethod evaluationMethod = new EvaluationMethod();
        evaluationMethod.setId(1L);
        evaluationMethod.setName("Homework");
        evaluationMethod.setCoefficient(1.5);

        assertNotNull(evaluationMethod);
        assertEquals(1L, evaluationMethod.getId());
        assertEquals("Homework", evaluationMethod.getName());
        assertEquals(1.5, evaluationMethod.getCoefficient());
    }

    @Test
    void testGettersAndSetters() {
        evaluationMethod.setId(2L);
        evaluationMethod.setName("Project");
        evaluationMethod.setCoefficient(3.0);

        assertEquals(2L, evaluationMethod.getId());
        assertEquals("Project", evaluationMethod.getName());
        assertEquals(3.0, evaluationMethod.getCoefficient());
    }

    @Test
    void testToString() {
        String expected = "EvaluationMethod [id=1, name=Exam, coefficient=2.5]";
        assertEquals(expected, evaluationMethod.toString());
    }

    @Test
    void testEquals() {
        EvaluationMethod anotherMethod = new EvaluationMethod();
        anotherMethod.setId(1L);
        anotherMethod.setName("Exam");
        anotherMethod.setCoefficient(2.5);

        assertTrue(evaluationMethod.equals(anotherMethod));

        anotherMethod.setName("Homework");
        assertFalse(evaluationMethod.equals(anotherMethod));
    }
}
