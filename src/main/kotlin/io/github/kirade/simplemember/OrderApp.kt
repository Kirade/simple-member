package io.github.kirade.simplemember

import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import io.github.kirade.simplemember.member.MemberService
import io.github.kirade.simplemember.member.MemberServiceImpl
import io.github.kirade.simplemember.order.OrderService
import io.github.kirade.simplemember.order.OrderServiceImpl


fun main() {
    val memberService: MemberService = MemberServiceImpl()
    val orderService: OrderService = OrderServiceImpl()


    val memberId = 1L
    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000)

    println(order)
    println(order.calculatePrice())
}