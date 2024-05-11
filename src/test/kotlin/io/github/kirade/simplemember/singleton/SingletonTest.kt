package io.github.kirade.simplemember.singleton

import io.github.kirade.simplemember.AppConfig
import io.github.kirade.simplemember.member.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    fun pureContainer() {
        val appConfig = AppConfig()

        val memberService1= appConfig.memberService()
        val memberService2 = appConfig.memberService()

        assertThat(memberService1).isNotSameAs(memberService2)
    }

    @Test
    @DisplayName("싱글턴 패턴을 적용한 객체 사용")
    fun singletonServiceTest() {
        val service1 = SingletonService.getInstance()
        val service2 = SingletonService.getInstance()

        assertThat(service1).isSameAs(service2)
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글턴")
    fun springContainer() {
        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberService1= ac.getBean("memberService", MemberService::class.java)
        val memberService2 = ac.getBean("memberService", MemberService::class.java)

        assertThat(memberService1).isSameAs(memberService2)
    }

}