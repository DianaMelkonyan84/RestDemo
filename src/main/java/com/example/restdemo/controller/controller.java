package com.example.restdemo.controller;

import com.example.restdemo.models.dto.UserDto;
import com.example.restdemo.models.entity.User;
import com.example.restdemo.models.response.UserResponse;
import com.example.restdemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class controller {

    public controller(UserService userService) {
        this.userService = userService;
    }

    private final UserService userService;

    @GetMapping("/users")
    @ApiOperation("Get all users list")
    public ResponseEntity<UserResponse> getAllUsers() {
        return ResponseEntity.ok(new UserResponse(userService.getAllUsers()));
    }

    @GetMapping("/users/{id}")
    @ApiOperation("Get a product by id")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @DeleteMapping("/users/{id}")
    @ApiOperation("Delete a user by id")
    public void deleteUserById(@PathVariable(name = "id") long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/users")
    @ApiOperation("Add a user")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user) {
        UserDto userDto = userService.addUser(user);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/users/{id}")
    @ApiOperation("Update a user")
    public ResponseEntity<UserDto> updateUser(@PathVariable(name="id") long id,@RequestBody UserDto updatedUser){

        UserDto updateUserDto=userService.updateUser(id,updatedUser);
        if(updateUserDto !=null){
            return ResponseEntity.ok(updateUserDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
