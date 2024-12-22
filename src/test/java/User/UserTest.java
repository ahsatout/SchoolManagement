package com.hyh.schoolmanagement.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        // Initialisation de l'objet User avant chaque test
        user = new User(1L, "Bouazzaelfatmi", "password123", Role.ADMINISTRATOR);
    }

    @Test
    void testConstructorWithAllFields() {
        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("Bouazzaelfatmi", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals(Role.ADMINISTRATOR, user.getRole());
    }

    @Test
    void testConstructorWithoutId() {
        User userWithoutId = new User("Bouazzaelfatmi", "password456", Role.PROFESSOR);
        assertNotNull(userWithoutId);
        //assertNull(userWithoutId.getId());  // Vérifie que l'id est null
        assertEquals("Bouazzaelfatmi", userWithoutId.getUsername());
        assertEquals("password456", userWithoutId.getPassword());
        assertEquals(Role.PROFESSOR, userWithoutId.getRole());
    }

    @Test
    void testSettersAndGetters() {
        user.setUsername("Bouchraqtibine");
        user.setPassword("123password");
        user.setRole(Role.PROFESSOR);

        assertEquals("Bouchraqtibine", user.getUsername());
        assertEquals("123password", user.getPassword());
        assertEquals(Role.PROFESSOR, user.getRole());
    }

    @Test
    void testClone() throws CloneNotSupportedException {
        User clonedUser = user.clone();

        assertNotNull(clonedUser);
        assertEquals(user.getId(), clonedUser.getId());
        assertEquals(user.getUsername(), clonedUser.getUsername());
        assertEquals(user.getPassword(), clonedUser.getPassword());
        assertEquals(user.getRole(), clonedUser.getRole());
        assertNotSame(user, clonedUser); // Vérifie que ce n'est pas la même instance
    }

    @Test
    void testToString() {
        String expected = "username = Bouazzaelfatmi, password = password123, role = ADMINISTRATOR";
        assertEquals(expected, user.toString());
    }

    @Test
    void testEquals() {
        User user1 = new User(1L, "Bouazzaelfatmi", "password123", Role.ADMINISTRATOR);
        User user3 = new User(2L, "Bouazzaelfatmi", "password456", Role.PROFESSOR);

        //assertTrue(user.equals(user1)); // Deux utilisateurs avec les mêmes attributs sont égaux
        assertFalse(user.equals(user3)); // Utilisateurs différents
        assertFalse(user.equals(null));  // Comparaison avec null
    }

}
