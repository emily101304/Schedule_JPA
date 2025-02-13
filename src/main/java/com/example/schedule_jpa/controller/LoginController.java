package com.example.schedule_jpa.controller;

import com.example.schedule_jpa.Const;
import com.example.schedule_jpa.dto.request.LoginRequestDto;
import com.example.schedule_jpa.dto.response.LoginResponseDto;
import com.example.schedule_jpa.dto.response.UserResponseDto;
import com.example.schedule_jpa.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PostMapping("/login")
    public void login(
            @Valid LoginRequestDto request, HttpServletResponse response
    ) {
        LoginResponseDto responseDto = userService.login(request.getEmail(),request.getPassword());
        if (responseDto.getId() == null) {
            throw new IllegalArgumentException("해당 유저는 존재하지 않습니다.");
        }

        Cookie cookie = new Cookie("userId", String.valueOf(responseDto.getId()));
        response.addCookie(cookie);
    }

    @PostMapping("/session-login")
    public void login(
            @Valid LoginRequestDto dto, HttpServletRequest request
    ) {
        LoginResponseDto responseDto = userService.login(dto.getEmail(),dto.getPassword());
        Long userId = responseDto.getId();

        if (userId == null) {
            throw new IllegalArgumentException("해당 유저는 존재하지 않습니다! 다시 확인해주세요!");
        }
        //Session request에 session이 존재하면 기존 것을 반환하고, 없으면 새로운 session을 생성한다.
        HttpSession session = request.getSession();
        //회원 정보 조회
        UserResponseDto loginUser = userService.findById(userId);
        //Session에 로그인 회원 정보를 저장한다.
        session.setAttribute(Const.LOGIN_USER, loginUser);
    }

    @PostMapping("/session-logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
