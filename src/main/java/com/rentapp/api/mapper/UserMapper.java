package com.rentapp.api.mapper;

import com.rentapp.api.dto.UserDto;
import com.rentapp.domain.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserDto toDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .email(user.getEmail())
                .build();
    }

    public List<UserDto> toDto(List<User> allUsers){
        return allUsers.stream()
                .map(user -> toDto(user))
                .collect(Collectors.toList());

    }
}
