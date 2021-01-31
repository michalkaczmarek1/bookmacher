package com.projects.bookmacher.controller;

import com.projects.bookmacher.domain.User;
import com.projects.bookmacher.domain.UserDto;
import com.projects.bookmacher.exception.UserNotFoundException;
import com.projects.bookmacher.mapper.UserMapper;
import com.projects.bookmacher.service.DbServiceUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private DbServiceUser dbServiceUser;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUsers() {
        List<User> users = dbServiceUser.getAllUsers();
        List<UserDto> userDtos = userMapper.mapToUserDtos(users);
        return userDtos;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public UserDto getUser(@PathVariable Long id) throws UserNotFoundException {
        return userMapper.mapToUserDto(
                dbServiceUser.getUser(id).orElseThrow(UserNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        dbServiceUser.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        user = dbServiceUser.saveUser(user);
        return userMapper.mapToUserDto(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        dbServiceUser.deleteUser(id);
    }

}
