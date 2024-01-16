package com.hepsiemlak.todoapp.business.abstracts;

import com.hepsiemlak.todoapp.business.requests.CreateTaskRequest;
import com.hepsiemlak.todoapp.entities.concretes.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getTasksByUserId(Long userId);
    void addTask(CreateTaskRequest createTaskRequest);
    List<Task> getAllTasks();
    Task getOneTaskById(Long taskId);
    void deleteById(Long taskId);

}
