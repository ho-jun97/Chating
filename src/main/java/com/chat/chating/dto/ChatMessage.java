package com.chat.chating.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatMessage{
    private Long userId;
    private Long roomId;
    private String sender;
    private String senderEmail;
    private String message;

//    @JsonSerialize(using = LocalDateTimeSerializer.class) // 레디스에 집어넣기 위해 설정
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class) // 레디스에 집어넣기 위해 설정
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime time;
}
