package com.example.groundstreet.redis

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension

//@ActiveProfiles("local")
//@ExtendWith(SpringExtension::class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
@SpringBootTest
open class RedisTest @Autowired constructor(
    val redisTemplate: RedisTemplate<String, Any>
){
    @Test
    fun `push and pop `() {
        // given
        val data = "{bar:123}"
        redisTemplate.opsForList().leftPush("foo", data)

        // when
        val result = redisTemplate.opsForList().rightPop("foo")

        // then
        assertThat(data).isEqualTo(result)
    }
}