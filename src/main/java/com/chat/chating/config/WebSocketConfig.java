package com.chat.chating.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // socket 연결 url : SockJS
                .setAllowedOriginPatterns("*"); // CORS 허용 범위
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub"); // 구독 url : 해당 주소를 구독하고 있는 클라이언트에게 메세지 전달
        registry.setApplicationDestinationPrefixes("/pub"); // prefix 정의 : 클라이언트에서 보낸 메세지를 받을 prefix
    }
}
