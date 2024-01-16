package com.hepsiemlak.todoapp.business.concretes;

import com.hepsiemlak.todoapp.business.abstracts.UserService;
import com.hepsiemlak.todoapp.core.utilities.mappers.ModelMapperService;
import com.hepsiemlak.todoapp.entities.concretes.User;
import com.hepsiemlak.todoapp.repositories.abstracts.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    public User getOneUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User saveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
