<h1>Groundstreet</h1>

## Introduction
This is a stock trading system for the US NASDAQ market created for fun. The entire system is built based on Domain Driven Development (DDD) with the goal of implementing a Microservice architecture. The implementation process will follow the steps of defining basic requirements, defining events, defining domains and aggregates, designing APIs, and conducting unit tests.

## Service Requirements
    1. 사용자 관리 및 로그인
        - 초기 사용자는 1억원의 원화를 받는다.
        - 원화 및 코인의 입금 및 출금은 불가하다.
    2. 코인 주문
        - 사용자는 코인을 검색한다.
        - 사용자는 보유한 원화 내의 금액만큼 코인을 구매 및 판매할 수 있다.
        - 코인은 소수점 아래 첫째 자리까지 구매 및 판매가 가능하다.
        - 주문 가격에 도달하면, 주문이 체결된다.
        - 주문이 체결되기 전에 주문 취소가 가능하다.
        - 주문이 체결되기 전에 주문 수정이 가능하다.
        - 주문이 체결되기 전에는 사용자의 자산 중 보유 원화에는 변화가 없다.
        - 주문이 등록된 후 주문 가능한 원화 및 코인은 주문량만큼 감소한다.
        - 주문이 체결되면, 사용자의 보유 원화가 감소하고, 코인 개수 및 수익률 정보가 변경된다.
        - 주문 등록, 수정, 체결시 해당 정보가 카카오톡으로 발송된다.
        - 모든 주문 등록, 취소, 수정 기록은 기록된다.
    3. 자산 조회
        - 사용자는 본인의 자산을 조회 가능하다.
        - 자산 조회시 보유 원화, 코인, 수익률 정보를 확인한다.
        - 각 코인 별로 평균 매수가가 존재한다.
    4. 카카오톡
        - 주문 등록, 수정, 성공시 카카오톡으로 통보한다.


## Version
- Spring boot 3.1

## Requirements
- Java JDK 17+
- Gradle 7.6.1
- Kotlin 1.8.0
- junit 5.9.3
- spring.dependency-management 1.1.0


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
│   │   │               └── client
│   │   │                   └── UpbitWebSocketClient.kt
│   │   │               └── config
│   │   │                   └── WebSocketConfig.kt
│   │   │               └── handler
│   │   │                   └── UpbitWebSocketHandler.kt #Specific module for Upbit
│   │   │                   └── WebSocketSessionHandler.kt #Generic WebSocketSessionHandler.
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── kotlin
│           └── com
│               └── example
│                   └── groundstreet
│                       └── controller
│                           └── HelloWorldControllerTest.kt
│                       └── client
│                           └── WebSocketTest.kt
└── build.gradle
```