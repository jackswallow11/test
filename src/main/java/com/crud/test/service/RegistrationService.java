package com.crud.test.service;

import com.crud.test.entity.User;
import com.crud.test.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

   @Autowired
   private RegistrationRepository repo;
    public void saveUser(User user){
        repo.save(user);
    }
    public User fetchUserbyEmail(String email) {
        return repo.findByEmail(email);
    }
    public List<User> findAll() {
        return repo.findAll();
    }




}
