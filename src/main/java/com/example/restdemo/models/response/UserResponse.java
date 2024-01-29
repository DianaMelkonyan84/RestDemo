package com.example.restdemo.models.response;

import com.example.restdemo.models.dto.UserDto;

import java.util.List;

public class UserResponse {
    private List<UserDto> userList;
     public UserResponse(List<UserDto> userList){
         this.userList =userList;
     }

    public List<UserDto> getUserList() {
        return userList;
    }

    public void setUserList(List<UserDto> userList) {
        this.userList = userList;
    }
}
