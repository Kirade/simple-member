package io.github.kirade.simplemember.lifecycle

import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class BeanLifeCycleTest {

    @Configuration
    class LifeCycleConfig {
        @Bean
        fun networkClient():NetworkClient {
            val networkClient = NetworkClient()
            networkClient.setUrl("https://hello-spring.dev")
            return networkClient
        }
    }

    @Test
    fun lifeCycleTest() {
        val ac = AnnotationConfigApplicationContext(LifeCycleConfig::class.java)
        //val client = ac.getBean(NetworkClient::class.java)
        ac.close()
    }
}