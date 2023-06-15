package com.example.groundstreet.config

import com.example.groundstreet.handler.UpbitWebSocketHandler
import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry

@Configuration
@EnableWebSocket
open class WebSocketConfig: WebSocketConfigurer {

    // Server-side Setup
    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(UpbitWebSocketHandler(), "/websocket/v1")
            .setAllowedOrigins("*")
    }
}