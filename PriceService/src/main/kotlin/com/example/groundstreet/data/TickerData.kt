package com.example.groundstreet.data

import kotlinx.serialization.Serializable

@Serializable
data class TickerData (
    val type: String? = null,
    val code: String? = null,
    val trade_price: Double? = 0.0,
    val trade_date: String? = null,
    val trade_time: String? = null,
    val trade_timestamp: Long? = 0,
    val timestamp: Long? = 0
)

/*
[full data]
receivedMessage : {"type":"ticker","code":"KRW-ETH","opening_price":2178000.0000,"high_price":2179000.0000,"low_price":2175000.0000,"trade_price":2176000.0000,"prev_closing_price":2179000.00000000,"acc_trade_price":200367990.140180000000,"change":"FALL","change_price":3000.00000000,"signed_change_price":-3000.00000000,"change_rate":0.0013767783,"signed_change_rate":-0.0013767783,"ask_bid":"BID","trade_volume":0.04595588,"acc_trade_volume":92.05596395,"trade_date":"20230616","trade_time":"000728","trade_timestamp":1686874048329,"acc_ask_volume":68.81680725,"acc_bid_volume":23.23915670,"highest_52_week_price":2795000.00000000,"highest_52_week_date":"2023-04-16","lowest_52_week_price":1201500.00000000,"lowest_52_week_date":"2022-06-18","market_state":"ACTIVE","is_trading_suspended":false,"delisting_date":null,"market_warning":"NONE","timestamp":1686874050030,"acc_trade_price_24h":36831516545.15682000,"acc_trade_volume_24h":17058.19057358,"stream_type":"REALTIME"}
 */