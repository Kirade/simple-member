package io.github.kirade.simplemember.web

import io.github.kirade.simplemember.common.MyLogger
import org.springframework.stereotype.Service

@Service
class LogDemoService(val myLogger: MyLogger) {

    fun logic(s: String) {
        myLogger.log("service id: $s")
    }

}
