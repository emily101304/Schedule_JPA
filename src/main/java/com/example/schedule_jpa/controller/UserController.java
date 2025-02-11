package com.example.schedule_jpa.controller;

import com.example.schedule_jpa.dto.request.CreateUserRequestDto;
import com.example.schedule_jpa.dto.response.UserResponseDto;
import com.example.schedule_jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserResponseDto> save(@RequestBody CreateUserRequestDto dto) {
        return ResponseEntity.ok(userService.save(dto));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> findOne(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.findById(userId));
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long userId, @RequestBody CreateUserRequestDto dto) {
        return ResponseEntity.ok(userService.update(userId,dto));
    }

    @DeleteMapping("/users/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.deleteById(userId);
    }
}
