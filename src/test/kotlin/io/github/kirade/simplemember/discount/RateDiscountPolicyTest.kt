package io.github.kirade.simplemember.discount

import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RateDiscountPolicyTest {
    val discountPolicy: RateDiscountPolicy = RateDiscountPolicy()

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    fun vip_o() {
        val member = Member(1L, "memberVIP", Grade.VIP)

        val discount = discountPolicy.discount(member, 10000)

        assertThat(discount).isEqualTo(1000)
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    fun vip_x() {
        val member = Member(2L, "memberBasic", Grade.BASIC)

        val discount = discountPolicy.discount(member, 10000)

        assertThat(discount).isEqualTo(0)
    }
}