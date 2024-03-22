package com.chat.chating.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginDto {
    private String id;
    private String pw;
}
