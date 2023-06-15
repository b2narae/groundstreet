package com.example.groundstreet.client

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WebSocketTest {
    @Autowired
    private lateinit var upbitWebSocketClient: UpbitWebSocketClient

    @Test
    fun testWebSocketConnection() {
        upbitWebSocketClient.connectToUpbitWebSocket()
        Thread.sleep(50000)
    }
}