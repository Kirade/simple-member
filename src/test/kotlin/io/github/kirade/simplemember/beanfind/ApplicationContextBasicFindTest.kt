package io.github.kirade.simplemember.beanfind

import io.github.kirade.simplemember.AppConfig
import io.github.kirade.simplemember.member.MemberService
import io.github.kirade.simplemember.member.MemberServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextBasicFindTest {
    private val ac: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("빈 이름으로 조회")
    fun findBeanByName(){
        val memberService = ac.getBean("memberService", MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("타입으로 조회")
    fun findBeanByType(){
        val memberService = ac.getBean(MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    fun findBeanByConcreateType(){
        val memberService = ac.getBean(MemberServiceImpl::class.java)
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("빈 이름으로 조회X")
    fun findBeanByNameX() {
        assertThrows<NoSuchBeanDefinitionException> { ac.getBean("xxxx", MemberService::class.java) }
    }
}