package io.github.kirade.simplemember.singleton

import io.github.kirade.simplemember.AppConfig
import io.github.kirade.simplemember.member.MemberRepository
import io.github.kirade.simplemember.member.MemberServiceImpl
import io.github.kirade.simplemember.order.OrderServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ConfigurationSingletonTest {

    @Test
    fun configurationTest() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberService = ac.getBean("memberService", MemberServiceImpl::class.java)
        val orderService = ac.getBean("orderService", OrderServiceImpl::class.java)
        val memberRepository = ac.getBean("memberRepository", MemberRepository::class.java)

        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository)
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository)
    }

    @Test
    fun configurationDeep() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val bean = ac.getBean(AppConfig::class.java)
        println(bean.javaClass)
    }
}