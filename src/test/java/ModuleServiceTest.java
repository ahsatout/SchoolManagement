import com.hyh.schoolmanagement.Service.ModuleService;
import com.hyh.schoolmanagement.dao.ModuleDao;
import com.hyh.schoolmanagement.model.Filiere;
import com.hyh.schoolmanagement.model.Module;
import com.hyh.schoolmanagement.model.Semester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ModuleServiceTest {

    private ModuleDao moduleDaoMock;
    private ModuleService moduleService;

    @BeforeEach
    void setUp() {
        moduleDaoMock = Mockito.mock(ModuleDao.class);
        moduleService = new ModuleService(moduleDaoMock);
    }

    @Test
    void testGetAllModules() {
        Filiere filiere = new Filiere(1L, "Informatique", "INF");
        List<Module> mockModules = Arrays.asList(
                new Module(1L, "Programmation", filiere, Semester.S1),
                new Module(2L, "Base de données", filiere, Semester.S2)
        );
        when(moduleDaoMock.findAll()).thenReturn(mockModules);

        List<Module> result = moduleService.getAllModules();

        assertEquals(2, result.size());
        verify(moduleDaoMock, times(1)).findAll();
    }

    @Test
    void testGetModuleById() {
        Filiere filiere = new Filiere(1L, "Informatique", "INF");
        Module mockModule = new Module(1L, "Programmation", filiere, Semester.S1);
        when(moduleDaoMock.findById(1L)).thenReturn(Optional.of(mockModule));

        Optional<Module> result = moduleService.getModuleById(1L);

        assertTrue(result.isPresent());
        assertEquals("Programmation", result.get().getName());
        verify(moduleDaoMock, times(1)).findById(1L);
    }

    @Test
    void testAddModule() {
        Filiere filiere = new Filiere(1L, "Informatique", "INF");
        Module newModule = new Module("Algorithmes", filiere, Semester.S1);
        doNothing().when(moduleDaoMock).save(newModule);

        moduleService.addModule(newModule);

        verify(moduleDaoMock, times(1)).save(newModule);
    }

    @Test
    void testUpdateModule() {
        Filiere filiere = new Filiere(1L, "Informatique", "INF");
        Module existingModule = new Module(1L, "Programmation", filiere, Semester.S1);
        doNothing().when(moduleDaoMock).update(existingModule);

        moduleService.updateModule(existingModule);

        verify(moduleDaoMock, times(1)).update(existingModule);
    }

    @Test
    void testDeleteModule() {
        doNothing().when(moduleDaoMock).delete(1L);

        moduleService.deleteModule(1L);

        verify(moduleDaoMock, times(1)).delete(1L);
    }
}

