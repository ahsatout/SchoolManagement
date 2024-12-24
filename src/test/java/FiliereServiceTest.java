
import com.hyh.schoolmanagement.Service.FiliereService;
import com.hyh.schoolmanagement.dao.FiliereDao;
import com.hyh.schoolmanagement.model.Filiere;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FiliereServiceTest {

    private FiliereDao filiereDaoMock;
    private FiliereService filiereService;

    @BeforeEach
    void setUp() {
        filiereDaoMock = Mockito.mock(FiliereDao.class);
        filiereService = new FiliereService(filiereDaoMock);
    }

    @Test
    void testGetAllFilieres() {
        List<Filiere> mockFilieres = Arrays.asList(
                new Filiere(1L, "informatique et ingénierie de donnees", "iid"),
                new Filiere(2L, "Mécanique", "MEC")
        );
        when(filiereDaoMock.findAll()).thenReturn(mockFilieres);

        List<Filiere> result = filiereService.getAllFilieres();

        assertEquals(2, result.size());
        verify(filiereDaoMock, times(1)).findAll();
    }

    @Test
    void testGetFiliereById() {
        Filiere mockFiliere = new Filiere(1L, "Informatique", "INF");
        when(filiereDaoMock.findById(1L)).thenReturn(Optional.of(mockFiliere));

        Optional<Filiere> result = filiereService.getFiliereById(1L);

        assertTrue(result.isPresent());
        assertEquals("Informatique", result.get().getName());
        verify(filiereDaoMock, times(1)).findById(1L);
    }

    @Test
    void testAddFiliere() {
        Filiere newFiliere = new Filiere("Mathématiques", "MATH");
        doNothing().when(filiereDaoMock).save(newFiliere);

        filiereService.addFiliere(newFiliere);

        verify(filiereDaoMock, times(1)).save(newFiliere);
    }

    @Test
    void testUpdateFiliere() {
        Filiere existingFiliere = new Filiere(1L, "genie electrique", "GE");
        doNothing().when(filiereDaoMock).update(existingFiliere);

        filiereService.updateFiliere(existingFiliere);

        verify(filiereDaoMock, times(1)).update(existingFiliere);
    }

    @Test
    void testDeleteFiliere() {
        doNothing().when(filiereDaoMock).delete(1L);

        filiereService.deleteFiliere(1L);

        verify(filiereDaoMock, times(1)).delete(1L);
    }
}
