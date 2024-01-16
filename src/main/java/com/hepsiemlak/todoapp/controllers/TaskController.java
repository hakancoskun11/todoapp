package com.hepsiemlak.todoapp.controllers;

import com.hepsiemlak.todoapp.business.abstracts.TaskService;
import com.hepsiemlak.todoapp.business.requests.CreateTaskRequest;
import com.hepsiemlak.todoapp.business.requests.TaskUpdateRequest;
import com.hepsiemlak.todoapp.entities.concretes.Task;

import com.hepsiemlak.todoapp.repositories.abstracts.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("tasks")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;
    private TaskRepository taskRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Task>> getTasksByUserId(@PathVariable Long userId) {
        return new ResponseEntity<>(taskService.getTasksByUserId(userId), HttpStatus.OK);
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateTaskRequest request) {
        this.taskService.addTask(request);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @PutMapping("/{taskId}")
    public Task updateOneTaskById(Long taskId, TaskUpdateRequest updateTask) {
        Task toUpdate = taskService.getOneTaskById(taskId);
        if(toUpdate != null) {
            toUpdate.setDesc(updateTask.getDesc());
            taskRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    @DeleteMapping("/{taskId}")
    public void deleteOneTaskById(Long taskId) {
        taskService.deleteById(taskId);
    }
}
