package com.virendra.firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virendra.firstproject.entity.Users;
import com.virendra.firstproject.repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    

    public void saveUser(Users user){
        repository.save(user);
    }

    public List<Users> getAllUser(){
        return repository.findAll();
    }

    public Users getUser(int id){
        return repository.findById(id).get();
    }

    public void deleteUserById(int id){
        repository.deleteById(id);
    }
}
