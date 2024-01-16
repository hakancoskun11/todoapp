package com.hepsiemlak.todoapp.business.abstracts;

import com.hepsiemlak.todoapp.business.requests.RegisterUserRequest;
import com.hepsiemlak.todoapp.entities.concretes.User;

public interface UserService {

    User getOneUserByUsername(String username);

    User saveOneUser(User newUser);

    User getOneUserById(Long userId);

}
