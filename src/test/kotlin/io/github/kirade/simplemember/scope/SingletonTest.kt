package io.github.kirade.simplemember.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class SingletonTest {

    @Scope("singleton")
    class SingletonBean {
        @PostConstruct
        fun init() {
            println("SingletonBean.init")
        }

        @PreDestroy
        fun destroy() {
            println("SingletonBean.destroy")
        }
    }

    @Test
    fun singletonBeanFind() {
        val ac = AnnotationConfigApplicationContext(SingletonBean::class.java)
        val singletonBean1 = ac.getBean(SingletonBean::class.java)
        val singletonBean2 = ac.getBean(SingletonBean::class.java)

        println("singletonBean1: $singletonBean1")
        println("singletonBean2: $singletonBean2")
        assertThat(singletonBean1).isSameAs(singletonBean2)
        ac.close()
    }
}