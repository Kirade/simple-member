package io.github.kirade.simplemember.order

import io.github.kirade.simplemember.AppConfig
import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import io.github.kirade.simplemember.member.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderServiceTest {
    private lateinit var memberService: MemberService
    private lateinit var orderService: OrderService

    @BeforeEach
    fun beforeEach() {
        val appConfig = AppConfig()
        memberService = appConfig.memberService()
        orderService = appConfig.orderService()
    }


    @Test
    fun createOrder() {
        val memberId = 1L

        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)
        val order = orderService.createOrder(memberId, "itemA", 10000)

        assertThat(order.discountPrice).isEqualTo(1000)
    }
}