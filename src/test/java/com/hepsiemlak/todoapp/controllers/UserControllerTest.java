package com.hepsiemlak.todoapp.controllers;

import com.hepsiemlak.todoapp.business.abstracts.UserService;
import com.hepsiemlak.todoapp.business.responses.UserResponse;
import com.hepsiemlak.todoapp.core.utilities.exceptions.UserNotFoundException;
import com.hepsiemlak.todoapp.entities.concretes.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser_Success() {
        User newUser = new User();
        when(userService.saveOneUser(newUser)).thenReturn(newUser);
        ResponseEntity<Void> response = userController.createUser(newUser);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testCreateUser_InternalServerError() {
        User newUser = new User();
        when(userService.saveOneUser(newUser)).thenReturn(null);
        ResponseEntity<Void> response = userController.createUser(newUser);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    public void testGetOneUser_Success() {
        Long userId = 1L;
        User mockUser = new User();
        when(userService.getOneUserById(userId)).thenReturn(mockUser);

        UserResponse userResponse = userController.getOneUser(userId);

        assertNotNull(userResponse);
        assertEquals(mockUser.getId(), userResponse.getId());
        assertEquals(mockUser.getUsername(), userResponse.getUsername());
    }

    @Test
    public void testGetOneUser_UserNotFoundException() {
        Long userId = 1L;
        when(userService.getOneUserById(userId)).thenReturn(null);

        assertThrows(UserNotFoundException.class, () -> userController.getOneUser(userId));
    }
}