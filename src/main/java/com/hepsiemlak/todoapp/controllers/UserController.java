package com.hepsiemlak.todoapp.controllers;

import com.hepsiemlak.todoapp.business.abstracts.UserService;
import com.hepsiemlak.todoapp.business.requests.RegisterUserRequest;
import com.hepsiemlak.todoapp.business.responses.UserResponse;
import com.hepsiemlak.todoapp.core.utilities.exceptions.UserNotFoundException;
import com.hepsiemlak.todoapp.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
    private UserService userService;


    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody User newUser) {
        User user = userService.saveOneUser(newUser);
        if(user != null)
            return new ResponseEntity<>(HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{userId}")
    public UserResponse getOneUser(@PathVariable Long userId) {
        User user = userService.getOneUserById(userId);
        if(user == null) {
            throw new UserNotFoundException("Kullanıcı bulunamadı.");
        }
        return new UserResponse(user);
    }


}
