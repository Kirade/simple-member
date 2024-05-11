package io.github.kirade.simplemember

import io.github.kirade.simplemember.member.Grade
import io.github.kirade.simplemember.member.Member
import io.github.kirade.simplemember.member.MemberService
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext


fun main(args: Array<String>) {
    val applicationContext: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService: MemberService = applicationContext.getBean("memberService", MemberService::class.java)

    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val findMember: Member? = memberService.findMember(1L)

    println(member.name)
    println(findMember?.name)
}

