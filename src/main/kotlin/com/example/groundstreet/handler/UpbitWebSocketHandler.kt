package com.example.groundstreet.handler

import org.springframework.stereotype.Component
import org.springframework.web.socket.BinaryMessage
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.BinaryWebSocketHandler
import org.springframework.web.socket.handler.TextWebSocketHandler

// Custom handler for domain logic or business requirement.
@Component
class UpbitWebSocketHandler : BinaryWebSocketHandler() { // () : Kotlin Syntax -> Customization

    // called when "WebSocket" connection is established.
    override fun afterConnectionEstablished(session: WebSocketSession) {
        println("After Connection Established")

        val request = "[{\"ticket\" : \"test\"}, {\"type\" : \"ticker\", \"codes\": [\"KRW-BTC\"]}]"
        session.sendMessage(TextMessage(request))

        println("Request is sent")
    }

    override fun handleBinaryMessage(session: WebSocketSession, message: BinaryMessage) {
        println("handlerTextMessage")
        val receivedMessage = message.payload.array()
        val decodedMessage = String(receivedMessage, Charsets.UTF_8)
        println("receivedMessage : $decodedMessage")
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        println("afterConnectionClosed")
    }
}