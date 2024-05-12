package io.github.kirade.simplemember.common

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Component
import java.util.UUID

@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
class MyLogger {
    var uuid: String? = null
    var requestURL: String? = null

    fun log(message: String) {
        println("[$uuid] [$requestURL]: $message")
    }

    @PostConstruct
    fun init() {
        uuid = UUID.randomUUID().toString()
        println("[$uuid] request scope bean created: $this")
    }

    @PreDestroy
    fun close() {
        println("[$uuid] request scope bean closed: $this")
    }
}