package com.myapps.manager.model;

import com.myapps.manager.utils.RandomUtils;

public class User
{
    private final long id;
    private String username;
    private String password;

    public User(String username, String password)
    {
	super();
	this.id = RandomUtils.generateRandomNumber(1000, 9999);
	this.username = username;
	this.password = password;
    }

    public long getId()
    {
	return id;
    }

    public String getUsername()
    {
	return username;
    }

    public void setUsername(String username)
    {
	this.username = username;
    }

    public String getPassword()
    {
	return password;
    }

    public void setPassword(String password)
    {
	this.password = password;
    }

    @Override
    public int hashCode()
    {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj)
    {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	User other = (User) obj;
	if (id != other.id)
	    return false;
	if (password == null)
	{
	    if (other.password != null)
		return false;
	} else if (!password.equals(other.password))
	    return false;
	if (username == null)
	{
	    if (other.username != null)
		return false;
	} else if (!username.equals(other.username))
	    return false;
	return true;
    }

    @Override
    public String toString()
    {
	return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
