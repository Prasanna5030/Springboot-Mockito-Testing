package com.sl.userservice.service;

import com.sl.userservice.dto.UserDto;
import com.sl.userservice.model.User;

import java.util.List;

public interface UserService {

    public UserDto saveUser(UserDto userDto);

    public void deleteUserById(Long id);

//    public String updateUser(UserDto userDto);

    public List<User> getAllUsers();

    public User getUserById(Long id);
}
