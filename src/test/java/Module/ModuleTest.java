package com.hyh.schoolmanagement.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModuleTest {

    private Module module;
    private Filiere filiere;
    private Semester semester;

    @BeforeEach
    void setUp() {
        filiere = new Filiere(1L, "Info et Ing des données", "IID");
        semester = Semester.S1;
        module = new Module(1L, "Java", filiere, semester);
    }

    @Test
    void testConstructorWithAllFields() {
        assertNotNull(module);
        assertEquals(1L, module.getId());
        assertEquals("Java", module.getName());
        assertEquals(filiere, module.getFiliere());
        assertEquals(semester, module.getSemester());
    }

    @Test
    void testConstructorWithoutId() {
        Module moduleWithoutId = new Module("Big Data", filiere, semester);

        assertNull(moduleWithoutId.getId());
        assertEquals("Big Data", moduleWithoutId.getName());
        assertEquals(filiere, moduleWithoutId.getFiliere());
        assertEquals(semester, moduleWithoutId.getSemester());
    }

    @Test
    void testSettersAndGetters() {
        module.setName("Securité");
        module.setFiliere(new Filiere(2L, "Genie informatique", "GI"));
        module.setSemester(Semester.S2);

        assertEquals("Securité", module.getName());
        assertEquals("GI", module.getFiliere().getAcronym());
        assertEquals(Semester.S2, module.getSemester());
    }

    @Test
    void testToString() {
        String expected = "Module [id=1, name=Java, filiere=Filiere [id=1, name=Info et Ing des données, acronym=IID], semester=S1]";
        assertEquals(expected, module.toString());
    }
}
