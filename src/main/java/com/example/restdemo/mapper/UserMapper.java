package com.example.restdemo.mapper;

import com.example.restdemo.models.dto.UserDto;
import com.example.restdemo.models.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
    List<UserDto> toDtoList(List<User> users);

}
