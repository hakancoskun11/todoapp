package com.hepsiemlak.todoapp.business.responses;

import com.hepsiemlak.todoapp.entities.concretes.User;
import lombok.Data;

@Data
public class UserResponse {

    Long id;
    String username;

    public UserResponse(User entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
    }
}