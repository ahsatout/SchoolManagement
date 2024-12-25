import com.hyh.schoolmanagement.Service.ProfessorService;
import com.hyh.schoolmanagement.dao.ProfessorDao;
import com.hyh.schoolmanagement.model.Professor;
import com.hyh.schoolmanagement.model.Speciality;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProfessorServiceTest {

    private ProfessorDao professorDao;
    private ProfessorService professorService;

    @BeforeEach
    void setUp() {
        professorDao = mock(ProfessorDao.class);
        professorService = new ProfessorService(professorDao);
    }

    @Test
    void getAllProfessors_ShouldReturnAllProfessors() {
        // Arrange
        List<Professor> mockProfessors = Arrays.asList(
                new Professor(1L, "John", "Doe", "Math"),
                new Professor(2L, "Jane", "Smith", "Physics")
        );
        when(professorDao.findAll()).thenReturn(mockProfessors);

        // Act
        List<Professor> professors = professorService.getAllProfessors();

        // Assert
        assertEquals(2, professors.size());
        verify(professorDao, times(1)).findAll();
    }

    @Test
    void getProfessorById_ShouldReturnProfessor_WhenIdExists() {
        // Arrange
        Professor mockProfessor = new Professor(1L, "John", "Doe", "Math");
        when(professorDao.findById(1L)).thenReturn(Optional.of(mockProfessor));

        // Act
        Optional<Professor> professor = professorService.getProfessorById(1L);

        // Assert
        assertTrue(professor.isPresent());
        assertEquals("John", professor.get().getFirstName());
        verify(professorDao, times(1)).findById(1L);
    }

    @Test
    void getProfessorById_ShouldReturnEmpty_WhenIdDoesNotExist() {
        // Arrange
        when(professorDao.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<Professor> professor = professorService.getProfessorById(1L);

        // Assert
        assertFalse(professor.isPresent());
        verify(professorDao, times(1)).findById(1L);
    }

    @Test
    void getProfessorsBySpeciality_ShouldReturnProfessors() {
        // Arrange
        Speciality speciality = new Speciality("Math");
        List<Professor> mockProfessors = Arrays.asList(
                new Professor(1L, "John", "Doe", "Math"),
                new Professor(2L, "Jane", "Smith", "Math")
        );
        when(professorDao.findBySpeciality(speciality)).thenReturn(mockProfessors);

        // Act
        List<Professor> professors = professorService.getProfessorsBySpeciality(speciality);

        // Assert
        assertEquals(2, professors.size());
        verify(professorDao, times(1)).findBySpeciality(speciality);
    }

    @Test
    void addProfessor_ShouldCallDaoSave() {
        // Arrange
        Professor newProfessor = new Professor("John", "Doe", "Math");

        // Act
        professorService.addProfessor(newProfessor);

        // Assert
        verify(professorDao, times(1)).save(newProfessor);
    }

    @Test
    void updateProfessor_ShouldCallDaoUpdate() {
        // Arrange
        Professor existingProfessor = new Professor(1L, "John", "Doe", "Math");

        // Act
        professorService.updateProfessor(existingProfessor);

        // Assert
        verify(professorDao, times(1)).update(existingProfessor);
    }

    @Test
    void deleteProfessor_ShouldCallDaoDelete() {
        // Arrange
        Long professorId = 1L;

        // Act
        professorService.deleteProfessor(professorId);

        // Assert
        verify(professorDao, times(1)).delete(professorId);
    }
}