package io.github.kirade.simplemember.beandefinition

import io.github.kirade.simplemember.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.support.GenericXmlApplicationContext
import org.springframework.context.support.beans

class BeanDefinitionTest {
    //private val ac = AnnotationConfigApplicationContext(AppConfig::class.java)
    private val ac = GenericXmlApplicationContext("appConfig.xml")

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    fun findApplicationBean() {
        val names = ac.beanDefinitionNames
        for (name in names) {
            val definition = ac.getBeanDefinition(name)

            if (definition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                println(definition)
            }
        }
    }
}