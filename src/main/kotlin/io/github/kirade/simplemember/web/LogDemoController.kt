package io.github.kirade.simplemember.web

import io.github.kirade.simplemember.common.MyLogger
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class LogDemoController(val logDemoService: LogDemoService, val myLogger: MyLogger) {

    @RequestMapping("log-demo")
    @ResponseBody
    fun logDemo(request: HttpServletRequest): String {
        val requestURL = request.requestURL.toString()

        println(myLogger.javaClass)

        myLogger.requestURL = requestURL

        myLogger.log("controller test")
        Thread.sleep(1000)
        logDemoService.logic("testId")
        return "OK"
    }

}