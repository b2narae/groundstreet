package com.example.groundstreet.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloWorldController {

    @GetMapping
    fun getHello(): List<Hello> {
        val dummyData = listOf(
            Hello(1, "Taekhwan", "b2narae@gmail.com"),
            Hello(2, "JeeHee", "JeeHee@gmail.com")
        )
        return dummyData
    }

}

data class Hello(val id: Long, val name: String, val email: String)