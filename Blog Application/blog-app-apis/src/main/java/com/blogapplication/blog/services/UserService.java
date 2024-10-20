package com.blogapplication.blog.services;

import com.blogapplication.blog.entities.User;
import com.blogapplication.blog.payloads.UserDto;

import java.util.List;

public interface UserService {
       UserDto createUser(UserDto user);
       UserDto updateUser(UserDto user, Integer userId);
       UserDto getUserById(Integer userId);
       List<UserDto> getAllUsers();
       void deleteUser(Integer userId);
}
