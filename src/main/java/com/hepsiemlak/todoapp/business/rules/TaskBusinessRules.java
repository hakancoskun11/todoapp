package com.hepsiemlak.todoapp.business.rules;

import com.hepsiemlak.todoapp.core.utilities.exceptions.BusinessException;
import com.hepsiemlak.todoapp.repositories.abstracts.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskBusinessRules {
    private TaskRepository taskRepository;

    public void checkIfTaskDescExistForUser(long intlUserId, String desc) {
        if(this.taskRepository.existsByUserIdAndDesc(intlUserId, desc)) {
            throw new BusinessException("Bu görev zaten eklendi.");
        }
    }
}
