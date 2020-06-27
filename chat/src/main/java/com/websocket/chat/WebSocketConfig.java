package com.websocket.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // 웹소켓 서버 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 클라이언트에서 웹소켓 서버에 연결하는데 사용할 엔드 포인트 설정

        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // message broker가 api를 구독하고 있는 클라이언트에게 메세지를 전달
        registry.enableSimpleBroker("/topic");
        // 클라이언트가 보낸 메세지를 받을 api의 prefix를 설정
        registry.setApplicationDestinationPrefixes("/app");
    }
}
