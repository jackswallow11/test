package com.crud.test.controller;

import com.crud.test.entity.Campaign;
import com.crud.test.payload.Status;
import com.crud.test.entity.User;
import com.crud.test.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    @PostMapping("/user/register")
    public Status registerUser(@RequestBody User user)  {
        String tempEmail = user.getEmail();
        if(tempEmail != null && !"".equals(tempEmail)){
            User userobj = service.fetchUserbyEmail(tempEmail);
            if(userobj != null){
                return Status.USER_ALREADY_EXISTS;
            }
        }
        service.saveUser(user);
        return Status.SUCCESS;
    }

    @PostMapping("/login")
    public Status loginUser(@RequestBody User user)  {
    List<User> users = service.findAll();
        for (User other : users) {
            if (other.equals(user)) {
                return Status.SUCCESS;
            }
        }

        return Status.FAILURE;
    }

    @GetMapping("/users")
    public List<User> findAllUser() {
        return service.findAll();
    }




}
