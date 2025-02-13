package com.example.schedule_jpa.service;

import com.example.schedule_jpa.dto.request.CreateUserRequestDto;
import com.example.schedule_jpa.dto.request.LoginRequestDto;
import com.example.schedule_jpa.dto.response.LoginResponseDto;
import com.example.schedule_jpa.dto.response.UserResponseDto;
import com.example.schedule_jpa.entity.User;
import com.example.schedule_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(CreateUserRequestDto dto) {
        User user = new User(dto.getName(), dto.getEmail(),dto.getPassword());
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail());
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(new UserResponseDto(user.getId(), user.getName(), user.getEmail()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public UserResponseDto findById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 일치하는 유저가 없습니다!")
        );
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    @Transactional
    public UserResponseDto update(Long userId, CreateUserRequestDto dto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 일치하는 유저가 없습니다!")
        );
        user.update(dto.getName(),dto.getEmail());
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail());
    }

    @Transactional
    public void deleteById(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("해당 유저는 존재하지 않습니다!");
        }
        userRepository.deleteById(userId);
    }

//    @Transactional
//    public LoginResponseDto login(LoginRequestDto dto) {
//
//    }

//    public LoginResponseDto login(String email, String password) {
//    }
}
