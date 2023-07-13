package com.rentapp.api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserCommand {
    private String login;
    private String password;
    private String email;
}
