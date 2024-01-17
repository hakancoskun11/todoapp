package com.hepsiemlak.todoapp.controllers;

import com.hepsiemlak.todoapp.business.abstracts.TaskService;
import com.hepsiemlak.todoapp.business.requests.CreateTaskRequest;
import com.hepsiemlak.todoapp.business.requests.TaskUpdateRequest;
import com.hepsiemlak.todoapp.entities.concretes.Task;
import com.hepsiemlak.todoapp.repositories.abstracts.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTasksByUserId() {
        Long userId = 1L;
        List<Task> mockTasks = Arrays.asList(new Task(), new Task());
        when(taskService.getTasksByUserId(userId)).thenReturn(mockTasks);
        ResponseEntity<List<Task>> response = taskController.getTasksByUserId(userId);
        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(mockTasks, response.getBody());
    }

    @Test
    public void testAddTask() {
        CreateTaskRequest createTaskRequest = new CreateTaskRequest();
        doNothing().when(taskService).addTask(createTaskRequest);
        taskController.add(createTaskRequest);

        verify(taskService).addTask(createTaskRequest);
    }

    @Test
    public void testGetAllTasks() {
        List<Task> mockTasks = Arrays.asList(new Task(), new Task());
        when(taskService.getAllTasks()).thenReturn(mockTasks);
        ResponseEntity<List<Task>> response = taskController.getAllTasks();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockTasks, response.getBody());
    }

    @Test
    public void testUpdateOneTaskById() {
        Long taskId = 1L;
        TaskUpdateRequest updateTask = new TaskUpdateRequest();
        updateTask.setDesc("Updated Desc");

        Task mockTask = new Task();
        when(taskService.getOneTaskById(taskId)).thenReturn(mockTask);
        when(taskRepository.save(mockTask)).thenReturn(mockTask);
        Task result = taskController.updateOneTaskById(taskId, updateTask);

        assertNotNull(result);
        assertEquals(updateTask.getDesc(), result.getDesc());
    }

    @Test
    public void testUpdateOneTaskById_NotFound() {
        // Arrange
        Long taskId = 1L;
        TaskUpdateRequest updateTask = new TaskUpdateRequest();
        updateTask.setDesc("Updated Desc");
        when(taskService.getOneTaskById(taskId)).thenReturn(null);
        Task result = taskController.updateOneTaskById(taskId, updateTask);

        assertNull(result);
    }

    @Test
    public void testDeleteOneTaskById() {
        Long taskId = 1L;
        taskController.deleteOneTaskById(taskId);

        verify(taskService).deleteById(taskId);
    }

}