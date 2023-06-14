package com.example.groundstreet.config

import org.springframework.context.annotation.Configuration

@Configuration
@EnableWebSocket
class WebSocketConfig : WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(MyWebSocketHandler(), "/my-websocket-endpoint").setAllowedOrigins("*")
    }
}