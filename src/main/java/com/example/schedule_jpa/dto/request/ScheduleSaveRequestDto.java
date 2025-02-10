package com.example.schedule_jpa.dto.request;

import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {

    private String username;
    private String title;
    private String content;
}
