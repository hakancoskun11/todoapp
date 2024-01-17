package com.hepsiemlak.todoapp.business.concretes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.hepsiemlak.todoapp.business.requests.CreateTaskRequest;
import com.hepsiemlak.todoapp.business.rules.TaskBusinessRules;
import com.hepsiemlak.todoapp.core.utilities.mappers.ModelMapperService;
import com.hepsiemlak.todoapp.entities.concretes.Task;
import com.hepsiemlak.todoapp.repositories.abstracts.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TaskManagerTest {

    @Mock
    private TaskRepository taskRepository;

    @Mock
    private TaskBusinessRules taskBusinessRules;

    @Mock
    private ModelMapperService modelMapperService;

    @InjectMocks
    private TaskManager taskManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTasksByUserId() {
        // Arrange
        Long userId = 1L;
        List<Task> mockTasks = Arrays.asList(new Task(), new Task());
        when(taskRepository.findByUserId(userId)).thenReturn(mockTasks);

        // Act
        List<Task> result = taskManager.getTasksByUserId(userId);

        // Assert
        assertEquals(mockTasks, result);
    }

    @Test
    public void testGetAllTasks() {
        List<Task> mockTasks = Arrays.asList(new Task(), new Task());
        when(taskRepository.findAll()).thenReturn(mockTasks);
        List<Task> result = taskManager.getAllTasks();

        assertEquals(mockTasks, result);
    }

    @Test
    public void testGetOneTaskById() {
        Long taskId = 1L;
        Task mockTask = new Task();
        when(taskRepository.findById(taskId)).thenReturn(Optional.of(mockTask));
        Task result = taskManager.getOneTaskById(taskId);

        assertEquals(mockTask, result);
    }

    @Test
    public void testGetOneTaskById_NotFound() {
        Long taskId = 1L;
        when(taskRepository.findById(taskId)).thenReturn(Optional.empty());
        Task result = taskManager.getOneTaskById(taskId);

        assertNull(result);
    }

    @Test
    public void testDeleteById() {
        Long taskId = 1L;
        taskManager.deleteById(taskId);

        verify(taskRepository).deleteById(taskId);
    }
}