package io.github.kirade.simplemember.beanfind

import io.github.kirade.simplemember.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextInfoTest {

    private val ac: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("모든 빈 출력하기")
    fun findAllBean() {
        val names = ac.beanDefinitionNames
        for (name in names) {
            val bean = ac.getBean(name)
            println("name: $name, object: $bean")
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    fun findApplicationBean() {
        val names = ac.beanDefinitionNames
        for (name in names) {
            val definition = ac.getBeanDefinition(name)

            if (definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                val bean = ac.getBean(name)
                println("name: $name, object: $bean")
            }
        }
    }
}