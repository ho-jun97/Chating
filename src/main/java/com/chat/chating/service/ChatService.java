package com.chat.chating.service;

import com.chat.chating.dto.ChatMessageDto;
import com.chat.chating.entity.Chat;
import com.chat.chating.entity.ChatRoom;
import com.chat.chating.repository.ChatRepository;
import com.chat.chating.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;
    private final ChatRoomRepository chatRoomRepository;

    public Chat createChat(Long roomId, String sender, String senderEmail, String message) {
        ChatRoom chatRoom = ChatRoom.createRoom(sender);
        return Chat.createChat(chatRoom, sender, senderEmail, message);
    }
}
