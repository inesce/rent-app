package com.rentapp.api;

import com.rentapp.api.dto.CreateUserCommand;
import com.rentapp.api.dto.UserDto;
import com.rentapp.api.mapper.UserMapper;
import com.rentapp.domain.entity.User;
import com.rentapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return userMapper.toDto(allUsers);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Long id) {
        User user = userService.get(id);
        return userMapper.toDto(user);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserCommand createUserCommand){
        return userService.create(createUserCommand);
    }



}
