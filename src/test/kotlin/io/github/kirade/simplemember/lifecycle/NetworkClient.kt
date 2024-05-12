package io.github.kirade.simplemember.lifecycle

import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean

class NetworkClient: InitializingBean, DisposableBean {

    private var url: String? = null

    init {
        println("생성자 호출: $url")
    }

    fun setUrl(url: String) {
        this.url = url
    }

    fun connect() {
        println("connect: $url")
    }

    fun call(message: String) {
        println("call: $url, message: $message")
    }

    fun disconnect() {
        println("close: $url")
    }

    override fun afterPropertiesSet() {
        connect()
        call("초기화 연결 메시지")
    }

    override fun destroy() {
        disconnect()
    }
}