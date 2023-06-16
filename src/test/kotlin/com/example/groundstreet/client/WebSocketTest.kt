package com.example.groundstreet.client

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.fail
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class WebSocketTest {
    @Autowired
    private lateinit var upbitWebSocketClient: UpbitWebSocketClient

    // always pass test
    @Test
    fun testWebSocketConnection() {
        val isConnectionSuccessful = upbitWebSocketClient.connectToUpbitWebSocket()
    }
}