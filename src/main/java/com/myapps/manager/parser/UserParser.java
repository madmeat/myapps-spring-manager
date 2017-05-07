package com.myapps.manager.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

import com.myapps.manager.model.User;

public class UserParser implements IUserParser
{
    private static final String COLON = ":";

    @Override
    public List<User> parseFromResource(String resourcePath) throws IOException
    {
	List<User> users = new LinkedList<>();
	try (BufferedReader bufferedReader = new BufferedReader(
		new InputStreamReader(getResourceAsStream(resourcePath), StandardCharsets.UTF_8)))
	{
	    bufferedReader.lines().forEach(line ->
	    {
		String[] usernameAndPassword = line.split(",");
		String username = usernameAndPassword[0].split(COLON)[1].trim();
		String password = usernameAndPassword[1].split(COLON)[1].trim();
		users.add(new User(username, password));
	    });
	}
	return users;
    }

    private InputStream getResourceAsStream(String resourcePath)
    {
	URL resourceUrl = this.getClass().getResource(resourcePath);
	try
	{
	    if (resourceUrl != null)
	    {
		return resourceUrl.openStream();
	    }
	    throw new IOException(String.format("Resource with name %s is not found", resourcePath));

	} catch (IOException e)
	{
	    throw new IllegalArgumentException(e);
	}
    }
}
