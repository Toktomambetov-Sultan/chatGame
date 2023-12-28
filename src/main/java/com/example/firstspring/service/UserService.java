package com.example.firstspring.service;

import com.example.firstspring.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto createUser (UserDto userDto);

    UserDto getUserByUserId(String id);

    UserDto getUser(String userName);

    void deleteUser(String userId);

    UserDto updateUser(String userId, UserDto userDto);

    List<UserDto> getUsers(int page, int limit);
}
