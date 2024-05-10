package com.chat.chating.service;

import com.chat.chating.dto.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RedisRepository {
    private final RedisTemplate<String, ChatMessage> redisTemplate;

    private static String redisPrefixKey = "chatMessages:";

    /**
     * roomId에 해당하는 redis 값 불러옴
     * @param roomId
     * @return
     */
    @Transactional(readOnly = true)
    public List<ChatMessage> find(Long roomId) {
        String key = redisPrefixKey+roomId;
        Long len = redisTemplate.opsForList().size(key);

        return redisTemplate.opsForList().range(key, 0, len - 1);
    }

    /**
     * roomId에 해당하는 redis에 메세지 저장
     * @param roomId
     * @param message
     */
    @Transactional
    public void save(Long roomId, ChatMessage message) {
        redisTemplate.opsForList().rightPush(redisPrefixKey + roomId, message);
    }

}
