package com.example.groundstreet.client

import com.example.groundstreet.handler.UpbitWebSocketHandler
import com.example.groundstreet.handler.WebSocketSessionHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.socket.client.WebSocketConnectionManager
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import java.net.URI

@Component
class UpbitWebSocketClient {
    @Autowired
    private lateinit var webSocketSessionHandler: WebSocketSessionHandler

    @Autowired
    private lateinit var upbitWebSocketHandler: UpbitWebSocketHandler

    fun connectToUpbitWebSocket() {
        webSocketSessionHandler.setDelegate(upbitWebSocketHandler)

        val uri = URI("wss://api.upbit.com/websocket/v1")
        val webSocketClient = StandardWebSocketClient()
        val connectionManager = WebSocketConnectionManager(webSocketClient, webSocketSessionHandler, uri.toString())
        connectionManager.start();
    }
}