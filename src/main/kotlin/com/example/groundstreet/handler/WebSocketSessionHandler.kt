package com.example.groundstreet.handler

import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.lang.reflect.Method

// [Seperation of concerns] focuses on the general WebSocket session manangement and lifecycle events
@Component
class WebSocketSessionHandler : TextWebSocketHandler() {
    private lateinit var delegate: TextWebSocketHandler
    private lateinit var handleTextMessageMethod: Method

    fun setDelegate(delegate: TextWebSocketHandler) {
        this.delegate = delegate
        handleTextMessageMethod = delegate.javaClass.getDeclaredMethod("handleTextMessage", WebSocketSession::class.java, TextMessage::class.java)
        handleTextMessageMethod.isAccessible = true
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        // Perform any general WebSocket session setup or initialization here
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        // Delegate the handling of text messages to the provided WebSocket handler
        handleTextMessageMethod.invoke(delegate, session, message)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        // Perform any cleanup or post-connection tasks here
    }
}