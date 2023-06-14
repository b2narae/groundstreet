package com.example.groundstreet.config

import com.example.groundstreet.handler.UpbitWebSocketHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(UpbitWebSocketHandler(), "/websocket/v1")
            .setAllowedOrigins("https://api.upbit.com")
            .setAllowedOrigins("http://api.upbit.com")
            .setAllowedOrigins("https://upbit.com")
            .setAllowedOrigins("http://upbit.com")
    }
}