package com.hepsiemlak.todoapp.repositories.abstracts;

import com.hepsiemlak.todoapp.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
