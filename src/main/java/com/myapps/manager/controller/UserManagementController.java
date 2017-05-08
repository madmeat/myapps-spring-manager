package com.myapps.manager.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myapps.manager.model.User;
import com.myapps.manager.service.IUserManagementService;

@RestController
public class UserManagementController
{
    @Autowired
    @Qualifier("usetManagementService")
    private IUserManagementService userManagementService;

    @RequestMapping(value = "/users/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<User>> getAllUsers()
    {
	List<User> users = userManagementService.getAllUsers();
	if (users.isEmpty())
	{
	    return new ResponseEntity<List<User>>(Collections.emptyList(), HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId)
    {
	User user = userManagementService.getUserById(userId);
	return user != null ? new ResponseEntity<User>(user, HttpStatus.OK)
		: new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
