package com.sl.userservice.controller;

import com.sl.userservice.dto.UserDto;
import com.sl.userservice.model.User;
import com.sl.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers(){
      return  userService.getAllUsers();
    }

    @PostMapping("/add")
    public UserDto addUser(@RequestBody UserDto userDto){
       return userService.saveUser(userDto);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") long id){
        return userService.getUserById(id);
    }

    @PostMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") long id){
        userService.deleteUserById(id);
    }


}
