package com.example.schedule_jpa.controller;

import com.example.schedule_jpa.dto.request.ScheduleSaveRequestDto;
import com.example.schedule_jpa.dto.response.ScheduleResponseDto;
import com.example.schedule_jpa.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleSaveRequestDto dto) {
        return ResponseEntity.ok(scheduleService.save(dto));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {
        return ResponseEntity.ok(scheduleService.findAll());
    }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findOne(@PathVariable Long scheduleId) {
        return ResponseEntity.ok(scheduleService.findById(scheduleId));
    }

    @PutMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long scheduleId, @RequestBody ScheduleSaveRequestDto dto) {
        return ResponseEntity.ok(scheduleService.update(scheduleId,dto));
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public void delete(@PathVariable Long scheduleId) {
        scheduleService.deleteById(scheduleId);
    }
}
