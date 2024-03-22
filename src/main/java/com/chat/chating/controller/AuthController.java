package com.chat.chating.controller;

import com.chat.chating.dto.LoginDto;
import com.chat.chating.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public @ResponseBody ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        authService.login(loginDto);
        return ResponseEntity.ok("로그인이 되셨습니다.");
    }
}
