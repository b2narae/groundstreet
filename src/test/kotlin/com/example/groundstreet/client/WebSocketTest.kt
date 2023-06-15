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

        Thread.sleep(5000)

        // Perform any assertions or checks to verify the WebSocket functionality
        // For example, you can check if certain messages were received or process the received data

        // Disconnect from the WebSocket
        // Perform any necessary cleanup
    }
}