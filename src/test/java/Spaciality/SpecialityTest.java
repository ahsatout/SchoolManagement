package Spaciality;

import com.hyh.schoolmanagement.model.Speciality;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SpecialityTest {

    private Speciality speciality;

    @BeforeEach
    void setUp() {
        // Initialisation de l'objet Speciality avant chaque test
        speciality = new Speciality("Mathematics");
    }


    @Test
    void testConstructorWithName() {
        Speciality speciality = new Speciality("Java");
        assertNotNull(speciality);
        assertEquals("Java", speciality.getName());
    }

    @Test
    void testConstructoWitoutName() {
        Speciality speciality = new Speciality();
        assertNotNull(speciality);
        assertNull(speciality.getName());
    }

    @Test
    void testGettersAndSetters() {
        speciality.setName("Computer Science");
        assertEquals("Computer Science", speciality.getName());
    }

    @Test
    void testToString() {
        String expected = "Speciality [name=Mathematics]";
        assertEquals(expected, speciality.toString());
    }

    @Test
    void testEquals() {
        Speciality speciality1 = new Speciality("Mathematics");
        Speciality speciality2 = new Speciality("Mathematics");
        Speciality speciality3 = new Speciality("Physics");

        assertTrue(speciality.equals(speciality1)); // Equality with the same name
        assertFalse(speciality.equals(speciality3)); // Not equal to a different name
        assertFalse(speciality.equals(null)); // Comparing with null
    }

    @Test
    void testHashCode() {
        Speciality speciality1 = new Speciality("Mathematics");
        Speciality speciality2 = new Speciality("Mathematics");

        assertEquals(speciality1.hashCode(), speciality2.hashCode()); // Same name, same hashCode
    }


}
