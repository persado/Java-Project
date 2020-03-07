package com.persado.assignment.project.service;

import com.persado.assignment.project.model.User;
import com.persado.assignment.project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user){
       return userRepository.save(user);
    }

    public void deleteUser(Long id){
        User user = userRepository.findUserById(id);
        userRepository.delete(user);
    }

    public User getUser(Long id){
        return userRepository.findUserById(id);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
