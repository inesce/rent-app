package com.rentapp.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {
    private Long id;
    private String login;
    private String email;
}
