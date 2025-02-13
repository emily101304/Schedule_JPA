package com.example.schedule_jpa.service;

import com.example.schedule_jpa.dto.request.ScheduleSaveRequestDto;
import com.example.schedule_jpa.dto.response.ScheduleResponseDto;
import com.example.schedule_jpa.entity.Schedule;
import com.example.schedule_jpa.entity.User;
import com.example.schedule_jpa.repository.ScheduleRepository;
import com.example.schedule_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleSaveRequestDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("해당 id로 존재하는 유저가 없습니다!")
        );
        Schedule schedule = new Schedule(dto.getUsername(),dto.getTitle(),dto.getContent(),user);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(
                savedSchedule.getId(),
                savedSchedule.getUsername(),
                savedSchedule.getTitle(),
                savedSchedule.getContent(),
                savedSchedule.getUser().getId());
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(
                    schedule.getId(),
                    schedule.getUsername(),
                    schedule.getTitle(),
                    schedule.getContent(),
                    schedule.getUser().getId()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 스케줄이 없습니다!")
        );
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getUsername(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getUser().getId());
    }

    @Transactional
    public ScheduleResponseDto update(Long scheduleId, ScheduleSaveRequestDto dto) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 스케줄이 없습니다!")
        );
        schedule.update(dto.getTitle(), dto.getContent());
        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getUsername(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getUser().getId()
        );
    }

    @Transactional
    public void deleteById(Long scheduleId) {
        if (!scheduleRepository.existsById(scheduleId)) {
            throw new IllegalArgumentException("해당 스케줄은 존재하지 않습니다.");
        }
        scheduleRepository.deleteById(scheduleId);
    }
}
