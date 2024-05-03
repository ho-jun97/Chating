package com.chat.chating.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatMessage {
    private Long userId;
    private Long roomId;
    private String sender;
    private String senderEmail;
    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;
}
