package com.hepsiemlak.todoapp.repositories.abstracts;

import com.hepsiemlak.todoapp.entities.concretes.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByUserId(Long userId);

    boolean existsByUserIdAndDesc(long intlUserId,String desc);
}
