package com.myapps.manager.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.google.common.collect.ImmutableList;
import com.myapps.manager.model.User;
import com.myapps.manager.parser.IUserParser;

@Service("usetManagementService")
public class UserManagementServiceImpl implements IUserManagementService
{
    private List<User> users;

    @Autowired
    @Qualifier("userParser")
    private IUserParser userParser;

    // init users section
    {
	try
	{
	    users = userParser.parseFromResource("/users");
	} catch (IOException e)
	{
	    throw new IllegalArgumentException(e);
	}
    }

    public User getUserById(Long id)
    {
	return findUser(user -> user.getId() == id);
    }

    public User getUserByUsername(String username)
    {
	return findUser(user -> user.getUsername().equals(username));
    }

    public List<User> getAllUsers()
    {
	return ImmutableList.copyOf(users);
    }

    public void deteleUserById(Long id)
    {
	User foundUser = findUser(user -> user.getId() == id);
	if (foundUser != null)
	{
	    users.remove(foundUser);
	}
    }

    public void deleteAllUsers()
    {
	users.clear();
    }

    public void createUser(User user)
    {
	users.add(user);
    }

    public void updateUser(User updatedUser)
    {
	long id = updatedUser.getId();
	User foundUser = findUser(user -> user.getId() == id);
	if (foundUser != null)
	{
	    foundUser.setUsername(updatedUser.getUsername());
	    foundUser.setPassword(updatedUser.getPassword());
	    return;
	}
	users.add(updatedUser);
    }

    public boolean isUserExist(User user)
    {
	long searchId = user.getId();
	Optional<Long> foundId = users.stream().mapToLong(User::getId).mapToObj(Long::new)
		.filter(id -> id.equals(searchId)).findFirst();
	if (foundId.isPresent())
	{
	    return true;
	}
	return false;
    }

    private User findUser(Predicate<User> predicate)
    {
	Optional<User> foundUser = users.stream().filter(predicate).findFirst();
	if (foundUser.isPresent())
	{
	    return foundUser.get();
	}
	return null;
    }
}
