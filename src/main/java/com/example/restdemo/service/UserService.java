package com.example.restdemo.service;

import com.example.restdemo.models.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(long id);
    void deleteUserById(long id);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(long id, UserDto userDto);


}
