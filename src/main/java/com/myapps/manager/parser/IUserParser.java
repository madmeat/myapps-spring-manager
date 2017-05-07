package com.myapps.manager.parser;

import java.io.IOException;
import java.util.List;

import com.myapps.manager.model.User;

public interface IUserParser
{
    public List<User> parseFromResource(String resourcePath) throws IOException;
}
