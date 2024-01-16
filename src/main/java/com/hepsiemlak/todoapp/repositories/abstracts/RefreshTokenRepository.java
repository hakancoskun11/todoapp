package com.hepsiemlak.todoapp.repositories.abstracts;

import com.hepsiemlak.todoapp.entities.concretes.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    RefreshToken findByUserId(Long userId);

}
