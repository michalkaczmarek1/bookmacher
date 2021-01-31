package com.projects.bookmacher.mapper;

import com.projects.bookmacher.domain.User;
import com.projects.bookmacher.domain.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {

    public List<UserDto> mapToUserDtos(List<User> users) {
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    public User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getAccount(),
                userDto.getCoupons()
        );
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getUsername(),
                user.getEmail(),
                user.getAccount(),
                user.getCoupons()
        );
    }

}
