package com.hyh.schoolmanagement.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FiliereTest {

    private Filiere filiere;

    @BeforeEach
    void setUp() {
        filiere = new Filiere(1L, "Info et Ing des données", "IID");
    }

    @Test
    void testConstructorWithId() {
        assertNotNull(filiere);
        assertEquals(1L, filiere.getId());
        assertEquals("Info et Ing des données", filiere.getName());
        assertEquals("IID", filiere.getAcronym());
    }

    @Test
    void testConstructorWithoutId() {
        Filiere filiereWithoutId = new Filiere("Genie Informatique", "GI");

        assertNull(filiereWithoutId.getId());
        assertEquals("Genie Informatique", filiereWithoutId.getName());
        assertEquals("GI", filiereWithoutId.getAcronym());
    }

    @Test
    void testSettersAndGetters() {
        filiere.setId(2L);
        filiere.setName("Genie Electrique");
        filiere.setAcronym("GE");

        assertEquals(2L, filiere.getId());
        assertEquals("Genie Electrique", filiere.getName());
        assertEquals("GE", filiere.getAcronym());
    }

    @Test
    void testAddModule() {
        Module module = new Module("Data Structures", filiere, Semester.S1);
        filiere.addModule(module);

        List<Module> modules = filiere.modules;

        assertEquals(1, modules.size());
        assertEquals(module, modules.get(0));
        assertEquals(filiere, module.getFiliere());
    }

    @Test
    void testToString() {
        String expected = "Filiere [id=1, name=Info et Ing des données, acronym=IID]";
        assertEquals(expected, filiere.toString());
    }
}
