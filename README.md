<h1>Groundstreet</h1>

## Introduction
This is a stock trading system for the US NASDAQ market created for fun. The entire system is built based on Domain Driven Development (DDD) with the goal of implementing a Microservice architecture. The implementation process will follow the steps of defining basic requirements, defining events, defining domains and aggregates, designing APIs, and conducting unit tests.

## Version
- Spring boot 3.1

## Requirements
- Java JDK 17+
- Gradle 7.6.1
- Kotlin 1.8.0

## Event Definition 
![Event Storming](Event%20Storming.png)

## Entity Model 
![Entity Modeler](Entity%20Modeler.png)

## Directory
```
groundstreet
├── src
│   ├── main
│   │   ├── kotlin
│   │   │   └── com
│   │   │       └── example
│   │   │           └── groundstreet
│   │   │               ├── Application.kt
│   │   │               └── controller
│   │   │                   └── HelloWorldController.kt #테스트용
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── kotlin
│           └── com
│               └── example
│                   └── groundstreet
│                       └── controller
│                           └── HelloWorldControllerTest.kt
└── build.gradle
```