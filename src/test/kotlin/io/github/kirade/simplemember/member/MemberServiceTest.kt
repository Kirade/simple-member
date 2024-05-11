package io.github.kirade.simplemember.member

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MemberServiceTest {

    private val memberService: MemberService = MemberServiceImpl()

    @Test
    fun join() {
        val member = Member(1L, "memberA", Grade.VIP)

        memberService.join(member)
        val findMember = memberService.findMember(member.id)

        assertThat(findMember).isEqualTo(member)
    }
}