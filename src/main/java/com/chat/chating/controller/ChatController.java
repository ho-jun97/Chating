package com.chat.chating.controller;

import com.chat.chating.dto.ChatMessage;
import com.chat.chating.dto.LoginDto;
import com.chat.chating.entity.Chat;
import com.chat.chating.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final ChatService chatService;
    private final SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/{roomId}") // 여기로 전송되면 메서드 호출 -> WebSocketConfig prefixes 에 적용한 거 앞에 생략
    @SendTo("/room/{roomId}") // 구독하고 있는 장소로 메시지 전송 (목적지) -> WebSocketConfig Broker 에서 적용한거 앞에 붙어야 함
    public void chat(@DestinationVariable Long roomId, ChatMessage message) {
//        Chat chat = chatService.createChat(roomId, message.getSender(), message.getSenderEmail(), message.getMessage());
//        log.debug("id : {}, message : {}",roomId,message.getMessage());
//
//        return ChatMessage.builder()
//                .roomId(roomId)
//                .sender(chat.getSender())
//                .senderEmail(chat.getSenderEmail())
//                .message(chat.getMessage())
//                .build();
        simpMessageSendingOperations.convertAndSend("/sub/room/"+roomId, message);
    }
}
