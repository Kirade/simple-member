package io.github.kirade.simplemember.lifecycle

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy

class NetworkClient {

    private var url: String? = null

    init {
        println("생성자 호출: $url")
    }

    fun setUrl(url: String) {
        this.url = url
    }

    private fun connect() {
        println("connect: $url")
    }

    private fun call(message: String) {
        println("call: $url, message: $message")
    }

    private fun disconnect() {
        println("close: $url")
    }

    @PostConstruct
    fun init() {
        connect()
        call("초기화 연결 메시지")
    }

    @PreDestroy
    fun close() {
        disconnect()
    }
}