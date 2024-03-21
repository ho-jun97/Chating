package com.chat.chating.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatMessage {
    private Long roomId;
    private String sender;
    private String senderEmail;
    private String message;
}
