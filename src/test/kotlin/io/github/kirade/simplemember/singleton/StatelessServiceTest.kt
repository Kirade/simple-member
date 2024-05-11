package io.github.kirade.simplemember.singleton

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

class StatelessServiceTest {

    class TestConfig {
        @Bean
        fun statelessService(): StatelessService = StatelessService()
    }

    @Test
    @DisplayName("상태가 존재하지 않는 서비스 검사")
    fun statelessServiceSingleton() {
        val ac = AnnotationConfigApplicationContext(TestConfig::class.java)
        val service1 = ac.getBean(StatelessService::class.java) as StatelessService
        val service2 = ac.getBean(StatelessService::class.java) as StatelessService

        val one = service1.order("nameA", 10000)
        val two = service2.order("nameA", 20000)

        assertThat(one).isEqualTo(10000)
        assertThat(two).isEqualTo(20000)
    }
}