package com.example.schedule_jpa.dto.request;

import lombok.Getter;

@Getter
public class ScheduleSaveRequestDto {

    private final String username;
    private final String title;
    private final String content;
    private final Long userId;

    public ScheduleSaveRequestDto(String username, String title, String content, Long userId) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.userId = userId;
    }
}
