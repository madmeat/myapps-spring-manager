package com.myapps.manager.service;

import java.util.List;

import com.myapps.manager.model.User;

public interface IUserManagementService
{
    public User getUserById(Long id);

    public User getUserByUsername(String username);

    public List<User> getAllUsers();

    public void deteleUserById(Long id);

    public void deleteAllUsers();

    public void createUser(User user);

    public void updateUser(User user);

    public boolean isUserExist(User user);
}
