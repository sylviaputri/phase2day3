package com.future.ojekOnline.service;

import com.future.ojekOnline.model.User;

import java.util.List;

public interface UserService {
    public abstract List<User> listUsers();
    public abstract User getUserById(Long id);
    public abstract User createUser(String nama, int balance);
    public abstract User updateUser(Long id, String nama, int balance);
    public abstract void deleteUser(Long id);
}
