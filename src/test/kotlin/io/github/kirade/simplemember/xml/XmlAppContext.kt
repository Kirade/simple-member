package io.github.kirade.simplemember.xml

import io.github.kirade.simplemember.member.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.context.support.GenericXmlApplicationContext

class XmlAppContext {

    @Test
    fun xmlAppContext() {
        val ac = GenericXmlApplicationContext("appConfig.xml")
        val memberService = ac.getBean("memberService", MemberService::class.java)
        assertThat(memberService).isInstanceOf(MemberService::class.java)
    }
}