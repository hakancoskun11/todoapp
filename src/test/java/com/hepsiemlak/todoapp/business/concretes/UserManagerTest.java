package com.hepsiemlak.todoapp.business.concretes;

import com.hepsiemlak.todoapp.core.utilities.mappers.ModelMapperService;
import com.hepsiemlak.todoapp.entities.concretes.User;
import com.hepsiemlak.todoapp.repositories.abstracts.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

public class UserManagerTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapperService modelMapperService;

    @InjectMocks
    private UserManager userManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOneUserByUsername() {
        String username = "testUser";
        User mockUser = new User();
        when(userRepository.findByUsername(username)).thenReturn(mockUser);
        User result = userManager.getOneUserByUsername(username);

        assertEquals(mockUser, result);
    }

    @Test
    public void testSaveOneUser() {
        User newUser = new User();
        when(userRepository.save(newUser)).thenReturn(newUser);
        User result = userManager.saveOneUser(newUser);

        assertEquals(newUser, result);
    }

    @Test
    public void testGetOneUserById() {
        Long userId = 1L;
        User mockUser = new User();
        when(userRepository.findById(userId)).thenReturn(java.util.Optional.of(mockUser));
        User result = userManager.getOneUserById(userId);

        assertEquals(mockUser, result);
    }

    @Test
    public void testGetOneUserById_NotFound() {
        Long userId = 1L;
        when(userRepository.findById(userId)).thenReturn(java.util.Optional.empty());
        User result = userManager.getOneUserById(userId);

        assertNull(result);
    }
}