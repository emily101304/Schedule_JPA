package com.example.schedule_jpa.dto.request;

import lombok.Getter;

@Getter
public class CreateUserRequestDto {

    private String name;
    private String email;
    private String password;
}
