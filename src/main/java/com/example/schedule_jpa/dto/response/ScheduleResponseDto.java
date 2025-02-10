package com.example.schedule_jpa.dto.response;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String username;
    private final String title;
    private final String content;

}
