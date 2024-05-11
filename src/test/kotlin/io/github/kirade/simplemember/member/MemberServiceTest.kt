package io.github.kirade.simplemember.member

import io.github.kirade.simplemember.AppConfig
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class MemberServiceTest {
    private lateinit var memberService: MemberService

    @BeforeEach
    fun beforeEach() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
    }

    @Test
    fun join() {
        val member = Member(1L, "memberA", Grade.VIP)

        memberService.join(member)
        val findMember = memberService.findMember(member.id)

        assertThat(findMember).isEqualTo(member)
    }
}