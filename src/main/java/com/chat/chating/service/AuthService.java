package com.chat.chating.service;

import com.chat.chating.dto.LoginDto;
import com.chat.chating.entity.Member;
import com.chat.chating.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;

    @Transactional
    public void login(LoginDto loginDto) {
        Member member = memberRepository.findByEmail(loginDto.getId()).orElseThrow(
                () -> new RuntimeException("회원을 찾을 수 없습니다."));

        if(!member.getPw().equals(loginDto.getPw())){
            throw new RuntimeException("로그인정보가 일치하지 않습니다.");
        }
    }
}
