package io.github.kirade.simplemember

import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import io.github.kirade.simplemember.member.MemberService
import io.github.kirade.simplemember.order.OrderService


fun main() {
    val appConfig = AppConfig()
    val memberService: MemberService = appConfig.memberService()
    val orderService: OrderService = appConfig.orderService()

    val memberId = 1L
    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000)

    println(order)
    println(order.calculatePrice())
}