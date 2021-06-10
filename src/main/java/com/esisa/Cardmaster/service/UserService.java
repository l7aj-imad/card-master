package com.esisa.Cardmaster.service;

import com.esisa.Cardmaster.dao.UserRepository;
import com.esisa.Cardmaster.exception.NotFoundException;
import com.esisa.Cardmaster.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private  final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(int id){
        return userRepository.findUserById(id)
                .orElseThrow(() -> new NotFoundException("User by id " + id + " was not found"));
    }
    
    public User getUser(String username){
        return userRepository.findUserByUsername(username)
                .orElseThrow(() -> new NotFoundException("User by id " + username + " was not found"));
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(User user){
        return  userRepository.save(user);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
}
