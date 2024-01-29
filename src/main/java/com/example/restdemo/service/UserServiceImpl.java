package com.example.restdemo.service;

import com.example.restdemo.exception.ResourceNotFoundException;
import com.example.restdemo.mapper.UserMapper;
import com.example.restdemo.models.dto.UserDto;
import com.example.restdemo.models.entity.User;
import com.example.restdemo.repository.UserRepasitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepasitory userRepasitory;
    @Autowired
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepasitory userRepasitory, UserMapper userMapper) {
        this.userRepasitory = userRepasitory;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepasitory.findAll();
        return userMapper.toDtoList(userList);
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userRepasitory.findById(id).orElseThrow(ResourceNotFoundException::new);
        return userMapper.toDto(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepasitory.deleteById(id);

    }

    @Override
    public UserDto addUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        User save = userRepasitory.save(user);
        return userMapper.toDto(save);
    }

    @Override
    public UserDto updateUser(long id, UserDto userDto) {
        Optional<User> userList=userRepasitory.findById(id);
        if(userList.isPresent()){
            User user = userList.get();
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            return userMapper.toDto(userRepasitory.save(user));
        }else{
            System.out.println();
            return null;
        }
    }
}
