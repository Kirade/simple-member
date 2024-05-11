package io.github.kirade.simplemember.singleton

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

class StatefulServiceTest {

    class TestConfig {
        @Bean
        fun statefulService(): StatefulService = StatefulService()
    }

    @Test
    fun statefulServiceSingleton() {
        val ac = AnnotationConfigApplicationContext(TestConfig::class.java)
        val statefulService1 = ac.getBean(StatefulService::class.java)
        val statefulService2 = ac.getBean(StatefulService::class.java)

        // ThreadA:  A 사용자가 10000원 주문
        statefulService1.order("userA", 10000)
        // ThreadB:  B 사용자가 10000원 주문
        statefulService2.order("userB", 20000)

        // ThreadA: 사용자 A 주문 금액 조회
        val price = statefulService1.price
        println(price)

        assertThat(statefulService1.price).isEqualTo(20000)
    }
}