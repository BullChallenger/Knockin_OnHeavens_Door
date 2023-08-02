package com.knockin.door.knockin_onheavens_door.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /**
         * Message Broker 로 전달
         * @argument("/queue") : Message 가 1:1 로 송신될 때, 사용할 Prefix Convention
         * @argument("/topic") : Message 가 1:N 으로 BroadCasting 될 때 사용할 Prefix Convention
         *
         * Message 가공을 위한 Handler
         * @Method:setApplicationDestinationPrefixes : Message Handler 로 Routing 되는 Prefix("/app") 을
         *                                             param 으로 지정할 수 있다.
         */
        registry.enableSimpleBroker("/queue", "/topic");
        registry.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gs-guide-websocket")
                .withSockJS();
    }
}
