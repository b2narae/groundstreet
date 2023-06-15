package com.example.groundstreet.handler

import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler

// Custom handler for domain logic or business requirement.
class UpbitWebSocketHandler : TextWebSocketHandler() { // () : Kotlin Syntax -> Customization

    // called when "WebSocket" connection is established.
    override fun afterConnectionEstablished(session: WebSocketSession) {
        println("after Connection Established")

        val request = "[{\"ticket\" : \"test\"}, {\"type\" : \"ticker\", \"codes\": [\"KRW-BTC\", \"KRW-ETH\"]}, {\"format\" : \"SIMPLE\"}]"
        session.sendMessage(TextMessage(request))
    }
    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        println("handlerTextMessage")

        val receivedMessage = message.payload
        println("receivedMessage : " + receivedMessage)

    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        println("afterConnectionClosed")
    }
}