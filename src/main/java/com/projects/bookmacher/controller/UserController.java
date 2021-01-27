package com.projects.bookmacher.controller;

import com.projects.bookmacher.domain.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<UserDto> getUsers() {
        //mapper lub service
        return new ArrayList<UserDto>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public void getUser(@PathVariable Long id) {
        //mapper lub service
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        //mapper lub service
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody UserDto userDto) {
        //mapper lub service
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        //mapper lub service
    }

}
