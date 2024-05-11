package io.github.kirade.simplemember.beanfind

import io.github.kirade.simplemember.beanfind.ApplicationContextSameBeanFindTest.SameBeanConfig
import io.github.kirade.simplemember.discount.DiscountPolicy
import io.github.kirade.simplemember.discount.FixDiscountPolicy
import io.github.kirade.simplemember.discount.RateDiscountPolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextExtendsFindTest {

    private val ac: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Configuration
    class TestConfig {
        @Bean
        fun rateDiscountPolicy() = RateDiscountPolicy()

        @Bean
        fun fixDiscountPolicy() = FixDiscountPolicy()
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면 중복 오류가 발생한다")
    fun findBeanByParentTypeDuplicate() {
        assertThrows<NoUniqueBeanDefinitionException> { ac.getBean(DiscountPolicy::class.java) }
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    fun findBeanByParentTypeBeanName() {
        val bean = ac.getBean("rateDiscountPolicy", DiscountPolicy::class.java)
        assertThat(bean).isInstanceOf(RateDiscountPolicy::class.java)
    }

    @Test
    @DisplayName("부모 타입으로 조회시 자식이 둘 이상 있으면, 특정 하위 타입으로 조회")
    fun findBeanBySubType() {
        val bean = ac.getBean(RateDiscountPolicy::class.java)
        assertThat(bean).isInstanceOf(RateDiscountPolicy::class.java)
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    fun findAllBeanByParentType() {
        val beans = ac.getBeansOfType(DiscountPolicy::class.java)
        for (bean in beans) {
            println(bean)
        }
        assertThat(beans).hasSize(2)
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    fun findAllBeanByObject() {
        val beans = ac.getBeansOfType(Object::class.java)
        for (bean in beans) {
            println(bean)
        }
    }
}
