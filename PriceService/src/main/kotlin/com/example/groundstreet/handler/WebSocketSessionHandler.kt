package com.example.groundstreet.handler

import org.springframework.stereotype.Component
import org.springframework.web.socket.BinaryMessage
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.BinaryWebSocketHandler
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.lang.reflect.Method

// [Seperation of concerns] focuses on the general WebSocket session manangement and lifecycle events
// 1. Setting Delegate (reflection)
@Component
class WebSocketSessionHandler : BinaryWebSocketHandler() {
    private lateinit var delegate: BinaryWebSocketHandler
    private lateinit var afterConnectionEstablishedMethod: Method
    private lateinit var handleBinaryMessageMethod: Method

    fun setDelegate(delegate: BinaryWebSocketHandler) {
        this.delegate = delegate
        afterConnectionEstablishedMethod = delegate.javaClass.getDeclaredMethod("afterConnectionEstablished", WebSocketSession::class.java)
        afterConnectionEstablishedMethod.isAccessible = true
        handleBinaryMessageMethod = delegate.javaClass.getDeclaredMethod("handleBinaryMessage", WebSocketSession::class.java, BinaryMessage::class.java)
        handleBinaryMessageMethod.isAccessible = true
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        // Perform any general WebSocket session setup or initialization here
        afterConnectionEstablishedMethod.invoke(delegate, session)
    }

    // Binary Message였음.
    override fun handleBinaryMessage(session: WebSocketSession, message: BinaryMessage) {
        handleBinaryMessageMethod.invoke(delegate, session, message)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        // Perform any cleanup or post-connection tasks here
        println("afterConnectionClosed")
    }
}