package com.example.schedule_jpa.dto.response;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String username;
    private final String title;
    private final String content;
    private final Long userId;

    public ScheduleResponseDto(Long id, String username, String title, String content, Long userId) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
