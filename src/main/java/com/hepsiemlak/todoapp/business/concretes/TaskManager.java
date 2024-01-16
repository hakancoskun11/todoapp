package com.hepsiemlak.todoapp.business.concretes;

import com.hepsiemlak.todoapp.business.abstracts.TaskService;
import com.hepsiemlak.todoapp.business.requests.CreateTaskRequest;
import com.hepsiemlak.todoapp.business.rules.TaskBusinessRules;
import com.hepsiemlak.todoapp.core.utilities.mappers.ModelMapperService;
import com.hepsiemlak.todoapp.entities.concretes.Task;
import com.hepsiemlak.todoapp.repositories.abstracts.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskManager implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskBusinessRules taskBusinessRules;
    private final ModelMapperService modelMapperService;
    @Override
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public void addTask(CreateTaskRequest createTaskRequest) {
        this.taskBusinessRules.checkIfTaskDescExistForUser(createTaskRequest.getUserId(),createTaskRequest.getDesc());

        Task task = modelMapperService.forRequst().map(createTaskRequest, Task.class);
        taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getOneTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public void deleteById(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
