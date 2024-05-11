package io.github.kirade.simplemember

import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import io.github.kirade.simplemember.member.MemberService
import io.github.kirade.simplemember.order.OrderService
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext


fun main() {
    val ac: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = ac.getBean("memberService", MemberService::class.java)
    val orderService = ac.getBean("orderService", OrderService::class.java)

    val memberId = 1L
    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10000)

    println(order)
    println(order.calculatePrice())
}