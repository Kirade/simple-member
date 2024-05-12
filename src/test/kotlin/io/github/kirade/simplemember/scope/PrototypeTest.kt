package io.github.kirade.simplemember.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class PrototypeTest {

    @Scope("prototype")
    class PrototypeBean {
        @PostConstruct
        fun init() {
            println("PrototypeBean.init")
        }

        @PreDestroy
        fun destroy() {
            println("PrototypeBean.destroy")
        }
    }

    @Test
    fun prototypeBeanFind() {
        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)
        println("find prototypeBean1")
        val prototypeBean1 = ac.getBean(PrototypeBean::class.java)
        println("find prototypeBean2")
        val prototypeBean2 = ac.getBean(PrototypeBean::class.java)

        println("prototypeBean1: $prototypeBean1")
        println("prototypeBean2: $prototypeBean2")
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2)

        ac.close()
    }
}