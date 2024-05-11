package io.github.kirade.simplemember.scan.Filter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

class ComponentFilterAppConfigTest {

    @Configuration
    @ComponentScan(
        includeFilters = [ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = [MyIncludeComponent::class]
        )],
        excludeFilters = [ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = [MyExcludeComponent::class]
        )]
    )
    class ComponentFilterAppConfig


    @Test
    fun filterScan() {
        val ac = AnnotationConfigApplicationContext(ComponentFilterAppConfig::class.java)

        val beanA = ac.getBean("beanA", BeanA::class.java)
        assertThat(beanA).isNotNull()

        assertThrows<NoSuchBeanDefinitionException> { ac.getBean("beanB", BeanB::class.java) }
    }
}