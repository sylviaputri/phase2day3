package com.future.ojekOnline.controller;

import com.future.ojekOnline.model.User;
import com.future.ojekOnline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/api/getAllUsers"}, method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.listUsers();
    }

    @RequestMapping(value = {"/api/getUserById/{id}"}, method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @RequestMapping(value = {"/api/getUserByNameAndPass/{name}/{pass}"}, method = RequestMethod.GET)
    public User getUserByNameAndPass(@PathVariable("name") String name,@PathVariable("pass") String pass){
        return userService.getUserByNameAndPassword(name,pass);
    }
}
