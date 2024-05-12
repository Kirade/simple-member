package io.github.kirade.simplemember.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import jakarta.inject.Provider
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class SingletonWithPrototypeTest1 {

    @Scope("singleton")
    class ClientBean(private val prototypeBeanProvider: Provider<PrototypeBean>) {

        fun logic(): Int{
            val prototypeBean = prototypeBeanProvider.get()
            prototypeBean.addCount()
            return prototypeBean.count
        }
    }

    @Scope("prototype")
    class PrototypeBean {
        var count: Int = 0

        fun addCount() {
            count++
        }

        @PostConstruct
        fun init(){
            println("PrototypeBean.init $this")
        }

        @PreDestroy
        fun destroy() {
            println("PrototypeBean.destroy")
        }
    }

    @Test
    fun prototypeFind() {
        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)

        val prototypeBean1 = ac.getBean(PrototypeBean::class.java)
        prototypeBean1.addCount()
        assertThat(prototypeBean1.count).isEqualTo(1)

        val prototypeBean2 = ac.getBean(PrototypeBean::class.java)
        prototypeBean2.addCount()
        assertThat(prototypeBean2.count).isEqualTo(1)
    }

    @Test
    fun singletonClientUsePrototype() {
        val ac = AnnotationConfigApplicationContext(ClientBean::class.java, PrototypeBean::class.java)

        val clientBean1 = ac.getBean(ClientBean::class.java)
        val count1 = clientBean1.logic()
        val clientBean2 = ac.getBean(ClientBean::class.java)
        val count2 = clientBean2.logic()

        assertThat(count1).isEqualTo(1)
        assertThat(count2).isEqualTo(1)

    }
}