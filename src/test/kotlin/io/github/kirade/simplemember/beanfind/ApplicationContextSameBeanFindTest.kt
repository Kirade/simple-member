package io.github.kirade.simplemember.beanfind

import io.github.kirade.simplemember.member.MemberRepository
import io.github.kirade.simplemember.member.MemoryMemberRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextSameBeanFindTest {
    private val ac: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(SameBeanConfig::class.java)

    @Configuration
    class SameBeanConfig {
        @Bean
        fun memberRepository1() = MemoryMemberRepository()

        @Bean
        fun memberRepository2() = MemoryMemberRepository()
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    fun findBeanByTypeDuplicate(){
        assertThrows<NoUniqueBeanDefinitionException> { ac.getBean(MemberRepository::class.java) }
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    fun findBeanByTypeDefineName(){
        val memberRepository = ac.getBean("memberRepository1", MemberRepository::class.java)
        assertThat(memberRepository).isInstanceOf(MemberRepository::class.java)
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    fun findAllBeanByType() {
        val beansOfType = ac.getBeansOfType(MemberRepository::class.java)
        for (mutableEntry in beansOfType) {
            println(mutableEntry)
        }
        assertThat(beansOfType.size).isEqualTo(2)
    }
}