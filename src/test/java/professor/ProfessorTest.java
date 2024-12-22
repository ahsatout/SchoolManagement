package professor;

import com.hyh.schoolmanagement.model.Element;
import com.hyh.schoolmanagement.model.Professor;
import com.hyh.schoolmanagement.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    private Professor professor1;
    private Professor professor2;

    @BeforeEach
    void setUp() {
        professor1 = new Professor(1L, "Mohammed", "Nasri", "Java");
        professor2 = new Professor("Nassima", "Soussi", "Big Data");
    }

    @Test
    void testConstructorWithSpecialityAsObject() {
        Speciality speciality = new Speciality("Computer Science");
        Professor professor = new Professor(2L, "Mohammed", "el khalfi", speciality);

        assertEquals(2L, professor.getId());
        assertEquals("Mohammed", professor.getFirstName());
        assertEquals("el khalfi", professor.getLastName());
        assertEquals("Computer Science", professor.getSpeciality().getName());
    }

    @Test
    void testConstructorWithSpecialityAsString() {
        assertEquals(1L, professor1.getId());
        assertEquals("Mohammed", professor1.getFirstName());
        assertEquals("Nasri", professor1.getLastName());
        assertEquals("Java", professor1.getSpeciality().getName());
    }

    @Test
    void testSettersAndGetters() {
        professor1.setFirstName("Amal");
        professor1.setLastName("Ourdou");
        professor1.setSpeciality(new Speciality("Js"));

        assertEquals("Amal", professor1.getFirstName());
        assertEquals("Ourdou", professor1.getLastName());
        assertEquals("Js", professor1.getSpeciality().getName());
    }


    @Test
    void testEquals() {
        Professor anotherProfessor = new Professor("Mohammed", "Nasri", "Java");
        assertTrue(professor1.equals(anotherProfessor));

        anotherProfessor.setFirstName("Nidal");
        assertFalse(professor1.equals(anotherProfessor));
    }

    @Test
    void testToString() {
        String expected = "Professor [id=1, firstName=Mohammed, lastName=Nasri, speciality=Java]";
        assertEquals(expected, professor1.toString());
    }


}



